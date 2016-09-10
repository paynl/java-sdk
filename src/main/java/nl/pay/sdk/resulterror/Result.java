package nl.pay.sdk.resulterror;

public class Result {
    public ResultRequest request = new ResultRequest();

    /**
     * getError - Returns the error
     * @return The error Pay.nl gave
     */
    public String getError()
    {
        return request.errorMessage;
    }

    /**
     * isReady - Did the request complete with success?
     * @return True if the request was completed okay.
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
