package nl.pay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import nl.pay.sdk.transactioninfo.TransactionInfoResult;

public class TransactionInfoService implements ServiceRequest {
    private String serviceId = "";
    private String token = "";
    private String transactionId = "";
    private String entranceCode = "";
    private String resultObject = "";

    private HttpServiceInteraction httpService = null;

    public void setServiceId(String val) {
        serviceId = val;
    }

    public void setToken(String val) {
        token = val;
    }

    public void setTransactionId(String val) {
        transactionId = val;
    }

    public void setEntranceCode(String val) {
        entranceCode = val;
    }

    public String startRequest() {
        String urlBase = "http://token:" + token + "@rest-api.pay.nl/v5/transaction/info/json";
        try {
            String data = Helper.addToUrl("transactionId", transactionId);
            if (!entranceCode.equals("")) {
                data += "&" + Helper.addToUrl("entranceCode", entranceCode);
            }
            if (httpService == null) {
                httpService = new HttpServiceInteraction();
            }

            httpService.setURL(urlBase);
            httpService.setParamData(data);
            this.resultObject = httpService.getResponse();
            return this.resultObject;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public TransactionInfoResult getResult() {
        if (this.resultObject.length() == 0) {
            this.startRequest();
        }

        Gson gson = new Gson();
        TransactionInfoResult result;
        try {
            result = gson.fromJson(this.resultObject, TransactionInfoResult.class);
        }
        catch (JsonSyntaxException exception) {
            // Okay, we've got error... trying again...
            result = new TransactionInfoResult();
            result.internalInit();
            result.request.result = "0";
            result.request.errorMessage = "Unable to process API response.";
        }

        return result;
    }
}
