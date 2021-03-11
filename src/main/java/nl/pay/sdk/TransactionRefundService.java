package nl.pay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import nl.pay.sdk.resulterror.Result;
import nl.pay.sdk.refund.*;

public class TransactionRefundService implements ServiceRequest {
    public String serviceId = "";
    public String token = "";

    public nl.pay.sdk.refund.Transaction refundData = new nl.pay.sdk.refund.Transaction();

    private HttpServiceInteraction httpService = null;
    private String resultObject = "";

    public void setTransactionId(String val)
    {
        refundData.setTransactionId(val);
    }
    public void setAmount(Integer val)
    {
        refundData.setAmount(val);
    }
    public void setDescription(String val)
    {
        refundData.setDescription(val);
    }
    public void setProcessDate(String val) throws Exception {
        refundData.setProcessDate(val);
    }
    public void setExchangeUrl(String val)
    {
        refundData.setExchangeUrl(val);
    }
    public void setCurrency(String val)
    {
        refundData.setCurrency(val);
    }

    public void setServiceId(String val) {
        serviceId = val;
    }

    public void setToken(String val) {
        token = val;
    }

    /**
     * validateInput
     * This function will do some basic validation to see if everything that's required has actually been set.
     * FIXME: I want to be fixed in the future please
     * @return always return true at the moment
     */
    private boolean validateInput() {
        return true;
    }


    public String startRequest() {
        String urlBase = "https://token:" + token + "@rest-api.pay.nl/v3/Refund/transaction/json";

        String data = Helper.addToUrl("serviceId", serviceId);
        // For the love of ...... - Why doesn't this use authentication but still requires the token?!
        data = data + "&" + Helper.addToUrl("token", token);

        data = data + "&" + Helper.addToUrl("transactionId",refundData.getTransactionId());

        if (refundData.getAmount() > 0)
        {
            data = data + "&" + Helper.addToUrl("amount",refundData.getAmount().toString());
        }

        if (refundData.getDescription().length() > 0)
        {
            data = data + "&" + Helper.addToUrl("description",refundData.getDescription());
        }
        if (refundData.getProcessDate().length() > 0)
        {
            data = data + "&" + Helper.addToUrl("processDate",refundData.getProcessDate());
        }
        if (refundData.getExchangeUrl().length() > 0)
        {
            data = data + "&" + Helper.addToUrl("exchangeUrl",refundData.getExchangeUrl());
        }
        if (refundData.getCurrency().length() > 0)
        {
            data = data + "&" + Helper.addToUrl("currency",refundData.getCurrency());
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

    public TransactionResult getResult() {
        if (this.resultObject.length() == 0) {
            this.startRequest();
        }

        TransactionResult result;
        Gson gson = new Gson();
        try {
            result = gson.fromJson(this.resultObject, TransactionResult.class);
        }
        catch (JsonSyntaxException exception) {
            // Okay, we've got error... trying again...
            try
            {
                Result error = gson.fromJson(this.resultObject, Result.class);
                result = new TransactionResult();
                result.internalInit();
                result.request.result = error.request.result;
                result.request.errorMessage = error.request.errorMessage;
                result.request.errorId = error.request.errorId;

            }
            catch(JsonSyntaxException exception2) {
                result = new TransactionResult();
                result.internalInit();
                result.request.result = "0";
                result.request.errorMessage = "Unable to process API response.";
            }
        }

        return result;
    }


}
