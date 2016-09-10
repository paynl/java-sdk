package nl.pay.sdk.servicelist;

public class ServiceListResult {

    public ServiceListResultRequest request;
    public ServiceListResultMerchant merchant;
    public ServiceListResultService service;
    public ServiceListResultCountryOptionList countryOptionList;

    /**
     * internalInit
     * Function to initialise when there isn't going to be a valid response,
     * and we still want to reply with valid response.
     */
    public void internalInit()
    {
        request = new ServiceListResultRequest();
        merchant = new ServiceListResultMerchant();
        service = new ServiceListResultService();
        countryOptionList = new ServiceListResultCountryOptionList();
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

}
