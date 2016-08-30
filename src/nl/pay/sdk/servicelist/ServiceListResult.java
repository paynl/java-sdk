package nl.pay.sdk.servicelist;

public class ServiceListResult {

    public ServiceListResultRequest request;
    public ServiceListResultMerchant merchant;
    public ServiceListResultService service;
    public ServiceListResultCountryOptionList countryOptionList;

    public void internalInit()
    {
        request = new ServiceListResultRequest();
        merchant = new ServiceListResultMerchant();
        service = new ServiceListResultService();
        countryOptionList = new ServiceListResultCountryOptionList();
    }
    private boolean isReady()
    {
        if (request.result.equalsIgnoreCase("1"))
        {
            return true;
        }
        return false;
    }

}
