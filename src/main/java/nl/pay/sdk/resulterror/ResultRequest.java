package nl.pay.sdk.resulterror;

public class ResultRequest {
    public String result = "";
    public String errorId = "";
    public String errorMessage = "";

    /**
     * getResult - Return the result status (did the request go okay?)
     * @return ServiceListResult status
     */
    public String getResult() {
        return result;
    }

    /**
     * getErrorId - Return the Error Id - if present
     * @return Error ID (if present)
     */
    public String getErrorId() {
        return errorId;
    }

    /**
     * getErrorMessage - Return the readable error message - if present
     * @return Readable error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
