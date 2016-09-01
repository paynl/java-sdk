package nl.pay.sdk.resulterror;

public class Result {
    public ResultRequest request = new ResultRequest();

    public String getError()
    {
        return request.errorMessage;
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
