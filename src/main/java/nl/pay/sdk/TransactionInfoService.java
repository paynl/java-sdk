package nl.pay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import nl.pay.sdk.resulterror.Result;
import nl.pay.sdk.transactioninfo.TransactionInfoResult;

public class TransactionInfoService implements ServiceRequest {
    private String serviceId = "";
    private String token = "";
    private String transactionId = "";
    private String entranceCode = "";
    private String resultObject = "";

    private HttpServiceInteraction httpService = null;

    /**
     * setServiceId - Sets the service ID of Pay.nl
     * @param val   Pay.nl service ID
     */
    public void setServiceId(String val) {
        serviceId = val;
    }

    /**
     * setToken - Sets the token for the Pay.nl API
     * @param val   Pay.nl API token for your account
     */
    public void setToken(String val) {
        token = val;
    }

    /**
     * setTransactionId - Set the transactionid you want to know the details about.
     * Within the system, this could also be known as 'Order ID'.
     * It's a numerical value with an X and afterwards a hexadecimal number. This uniquely identifies the transaction
     * within the system.
     *
     * @param val   Pay.nl transaction id
     */
    public void setTransactionId(String val) {
        transactionId = val;
    }

    /**
     * setEntranceCode - Set the entrance code, if this value is known.
     * Please note this function is optional, and will probably be deprecated in the future.
     * It does not really serve any purpose at the moment.
     *
     * The entrance code was provided by Pay.nl for certain transactions, to get or set more details.
     * At the moment, this is no longer being used actively.
     *
     * @deprecated  This isn't really useful.
     * @param val Entrance code of transaction
     *
     */
    public void setEntranceCode(String val) {
        entranceCode = val;
    }

    /**
     * startRequest - Starts the final request
     * @return Result of API call
     */
    public String startRequest() {
        String urlBase = "https://token:" + token + "@rest-api.pay.nl/v5/transaction/info/json";
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

    /**
     * getResult - Returns the result in parsed format
     * @return TransactionInfoResult object
     */
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
            try
            {
                Result error = gson.fromJson(this.resultObject, Result.class);
                result = new TransactionInfoResult();
                result.internalInit();
                result.request.errorId = error.request.errorId;
                result.request.errorMessage = error.request.errorMessage;
                result.request.result = error.request.result;
            }
            catch(JsonSyntaxException exception2)
            {
                result = new TransactionInfoResult();
                result.internalInit();
                result.request.result = "0";
                result.request.errorMessage = "Unable to process API response.";
            }
        }

        return result;
    }
}
