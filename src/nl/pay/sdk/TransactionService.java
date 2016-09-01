package nl.pay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import nl.pay.sdk.resulterror.Result;
import nl.pay.sdk.transaction.*;

public class TransactionService implements ServiceRequest {
    public String serviceId = "";
    public String token = "";
    public Integer amount = 0;
    public String ipAddress = "";
    public String finishUrl = "";
    public Integer paymentOptionId = 0;
    public Integer paymentOptionSubId = 0;
    public boolean testMode = false;
    public Transaction transactionData = new Transaction();
    public StatsData statsData = new StatsData();
    public EndUser endUser = new EndUser();
    public SaleData saleData = new SaleData();

    private HttpServiceInteraction httpService = null;
    private String resultObject = "";

    public void setPaymentOptionSubId(Integer val) {
        paymentOptionSubId = val;
    }

    public void setPaymentOptionId(Integer val) {
        paymentOptionId = val;
    }

    public void setfinishUrl(String val) {
        finishUrl = val;
    }

    public void setIpAddress(String val) {
        ipAddress = val;
    }

    public void setAmount(Integer val) {
        amount = val;
    }

    public void setServiceId(String val) {
        serviceId = val;
    }

    public void setToken(String val) {
        token = val;
    }


    public void setTestMode(boolean val) {
        testMode = val;
    }

    /**
     * validateInput
     * This function will do some basic validation to see if everything that's required has actually been set.
     *
     * @return
     */
    private boolean validateInput() {
        return true;
    }


    public String startRequest() {
        String urlBase = "http://token:" + token + "@rest-api.pay.nl/v5/transaction/start/json";

        String data = Helper.addToUrl("serviceId", serviceId) +
                "&" + Helper.addToUrl("amount", amount.toString()) +
                "&" + Helper.addToUrl("ipAddress", ipAddress) +
                "&" + Helper.addToUrl("finishUrl", finishUrl);

        // For the love of ...... - Why doesn't this use authentication but still requires the token?!
        data = data + "&" + Helper.addToUrl("token", token);

        if (paymentOptionId > 0) {
            data = data + "&" + Helper.addToUrl("paymentOptionId", paymentOptionId.toString());
        }
        if (paymentOptionSubId > 0) {
            data = data + "&" + Helper.addToUrl("paymentOptionSubId", paymentOptionSubId.toString());
        }
        if (transactionData.currency.length() > 0) {
            data = data + "&" + Helper.addToUrl("transaction[currency]", transactionData.currency);
        }
        if (transactionData.costsVat != 0) {
            data = data + "&" + Helper.addToUrl("transaction[costsVat]", transactionData.costsVat.toString());
        }
        data = data + "&" + Helper.addToUrl("transaction[orderExchangeUrl]", transactionData.orderExchangeUrl);
        if (transactionData.description.length() > 0) {
            data = data + "&" + Helper.addToUrl("transaction[description]", transactionData.description);
        }
        if (transactionData.enduserId != 0) {
            data = data + "&" + Helper.addToUrl("transaction[enduserId]", transactionData.enduserId.toString());
        }
        if (statsData.promoterId != 0) {
            data = data + "&" + Helper.addToUrl("statsData[promotorId]", statsData.promoterId.toString());
        }
        if (statsData.info.length() > 0) {
            data = data + "&" + Helper.addToUrl("statsData[info]", statsData.info);
        }

        if (statsData.tool.length() > 0) {
            data = data + "&" + Helper.addToUrl("statsData[tool]", statsData.tool);
        }

        if (statsData.extra1.length() > 0) {
            data = data + "&" + Helper.addToUrl("statsData[extra1]", statsData.extra1);
        }

        if (statsData.extra2.length() > 0) {
            data = data + "&" + Helper.addToUrl("statsData[extra2]", statsData.extra2);
        }

        if (statsData.extra3.length() > 0) {
            data = data + "&" + Helper.addToUrl("statsData[extra3]", statsData.extra3);
        }
        if (endUser.accessCode.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[accessCode]", endUser.accessCode);
        }

        if (endUser.language.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[language]", endUser.language);
        }

        if (endUser.initials.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[initials]", endUser.initials);
        }

        if (endUser.lastName.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[lastName]", endUser.lastName);
        }

        if (endUser.gender.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[gender]", endUser.gender);
        }

        if (endUser.dob.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[dob]", endUser.dob);
        }

        if (endUser.phoneNumber.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[phoneNumber]", endUser.phoneNumber);
        }

        if (endUser.emailAddress.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[emailAddress]", endUser.emailAddress);
        }

        if (endUser.iban.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[iban]", endUser.iban);
        }

        if (endUser.bic.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[bic]", endUser.bic);
        }
        if (endUser.confirmMailTemplate.length() > 0) {
            // Only send the confirmation mail when the confirmation mailtemplate has been set correctly.
            data = data + "&" + Helper.addToUrl("enduser[sendConfirmEmail]", (endUser.sendConfirmEmail ? "true" : "false"));
            data = data + "&" + Helper.addToUrl("enduser[confirmMailTemplate]", endUser.confirmMailTemplate);
        }


        if (endUser.address.streetName.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[address][streetName]", endUser.address.streetName);
        }

        if (endUser.address.streetNumber.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[address][streetNumber]", endUser.address.streetNumber);
        }

        if (endUser.address.zipCode.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[address][zipCode]", endUser.address.zipCode);
        }

        if (endUser.address.city.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[address][city]", endUser.address.city);
        }

        if (endUser.address.countryCode.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[address][countryCode]", endUser.address.countryCode);
        }
        if (endUser.invoiceAddress.initials.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][initials]", endUser.invoiceAddress.initials);
        }

        if (endUser.invoiceAddress.lastName.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][lastName]", endUser.invoiceAddress.lastName);
        }

        if (endUser.invoiceAddress.gender.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][gender]", endUser.invoiceAddress.gender);
        }

        if (endUser.invoiceAddress.streetName.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][streetName]", endUser.invoiceAddress.streetName);
        }

        if (endUser.invoiceAddress.streetNumber.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][streetNumber]", endUser.invoiceAddress.streetNumber);
        }

        if (endUser.invoiceAddress.zipCode.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][zipCode]", endUser.invoiceAddress.zipCode);
        }

        if (endUser.invoiceAddress.city.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][city]", endUser.invoiceAddress.city);
        }

        if (endUser.invoiceAddress.countryCode.length() > 0) {
            data = data + "&" + Helper.addToUrl("enduser[invoiceAddress][countryCode]", endUser.invoiceAddress.countryCode);
        }

        // Finally... last array :-)
        if (saleData.invoiceDate.length() > 0) {
            // Okay... Now all fields are required!
            data = data + "&" + Helper.addToUrl("saleData[invoiceDate]", saleData.invoiceDate);
            data = data + "&" + Helper.addToUrl("saleData[deliveryDate]", saleData.deliveryDate);
            Integer iterator = -1;
            for (Product product : saleData.orderData) {
                iterator++;
                data = data + "&" + Helper.addToUrl("saleData[orderData][" + iterator.toString() + "][productId]", product.productId);
                if (product.description.length() > 0) {
                    data = data + "&" + Helper.addToUrl("saleData[orderData][" + iterator.toString() + "][description]", product.description);
                }
                data = data + "&" + Helper.addToUrl("saleData[orderData][" + iterator.toString() + "][price]", product.price.toString());
                data = data + "&" + Helper.addToUrl("saleData[orderData][" + iterator.toString() + "][quantity]", product.quantity.toString());
                data = data + "&" + Helper.addToUrl("saleData[orderData][" + iterator.toString() + "][vatCode]", product.vatCode);
            }
        }
        if (testMode) {
            data = data + "&" + Helper.addToUrl("testMode", "1");
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
