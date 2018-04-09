package nl.pay.sdk.servicelist;

import java.util.*;

public class ServiceListResult {

    public Request request;
    public Merchant merchant;
    public Service service;

    public Map<String, Country> countryOptionList;

    /**
     * internalInit
     * Function to initialise when there isn't going to be a valid response,
     * and we still want to reply with valid response.
     */
    public void internalInit()
    {
        request = new Request();
        merchant = new Merchant();
        service = new Service();
        countryOptionList = new HashMap<String, Country>();
    }

    /**
     * isReady - Determines if the API call went okay
     * @return did the call go okay?
     */
    private boolean isReady()
    {
        if (request.result.equalsIgnoreCase("1"))
        {
            return true;
        }
        return false;
    }

    public Map<Integer, PaymentOption> getPaymentMethods(){
        Map<Integer, PaymentOption> paymentOptions = new HashMap<Integer, PaymentOption>();

        for(Country country :this.countryOptionList.values()){
            for(PaymentOption paymentOption: country.paymentOptionList.values()){
                if (!paymentOptions.containsKey(paymentOption.id)){
                    paymentOptions.put(paymentOption.id, paymentOption);
                }
            }
        }

        return paymentOptions;
    }
}
