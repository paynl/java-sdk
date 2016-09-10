package nl.pay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import nl.pay.sdk.resulterror.Result;
import nl.pay.sdk.servicelist.ServiceListResult;

public class ServiceListService implements ServiceRequest {
    private String serviceId = "";
    private String token = "";
    private String paymentMethodId = "";

    private HttpServiceInteraction httpService = null;
    private String resultObject = "";

    public void setServiceId(String val) {
        serviceId = val;
    }

    public void setToken(String val) {
        token = val;
    }

    public void setPaymentMethodId(String val) {
        paymentMethodId = val;
    }

    public String startRequest() {
        String urlBase = "https://rest-api.pay.nl/v5/transaction/getService/json";
        String data = Helper.addToUrl("token",token);
        data += "&" + Helper.addToUrl("serviceId",serviceId);
        if (!paymentMethodId.equals("")) {
            data += "&" + Helper.addToUrl("paymentMethodId",paymentMethodId);
        }
        if (httpService == null) {
            httpService = new HttpServiceInteraction();
        }

        httpService.setURL(urlBase);
        httpService.setParamData(data);
        try {
            this.resultObject = httpService.getResponse();
            return this.resultObject;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    public ServiceListResult getResult() {
        if (this.resultObject.length() == 0) {
            this.startRequest();
        }

        Gson gson = new Gson();
        ServiceListResult result;
        try {
            result = gson.fromJson(this.resultObject, ServiceListResult.class);
        }
        catch (JsonSyntaxException exception) {
            // Trying again, just to parse the error
            try {
                Result error = gson.fromJson(this.resultObject, Result.class);
                result = new ServiceListResult();
                result.internalInit();
                result.request.result = error.request.result;
                result.request.errorMessage = error.request.errorMessage;
                result.request.errorId = error.request.errorId;
            }
            catch(JsonSyntaxException exception2) {
                result = new ServiceListResult();
                result.internalInit();
                result.request.result = "0";
                result.request.errorMessage = "Unable to process API response.";
            }
        }

        return result;
    }
}
