package nl.pay.sdk.transaction;

public class TransactionResult {
    public TransactionResultRequest request;
    public TransactionResultEndUser endUser;
    public TransactionResultTransaction transaction;

    public void internalInit()
    {
        request = new TransactionResultRequest();
        endUser = new TransactionResultEndUser();
        transaction = new TransactionResultTransaction();
    }

    public String getError()
    {
        if (request == null)
        {
            internalInit();
        }
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

    public String getTransactionId()
    {
        if (request == null)
        {
            internalInit();
        }
        if (!isReady())
        {
            return "NOT-READY";
        }

        return transaction.transactionId;
    }
    public String getTransactionUrl()
    {
        if (request == null)
        {
            internalInit();
        }
        if (!isReady())
        {
            return "NOT-READY";
        }
        return transaction.paymentURL;
    }
}
