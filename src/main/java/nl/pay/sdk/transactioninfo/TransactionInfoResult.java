package nl.pay.sdk.transactioninfo;


public class TransactionInfoResult {
    public TransactionInfoResultRequest request;
    public TransactionInfoResultConnection connection;
    public EndUser enduser;
    public SaleData saleData;
    public TransactionInfoResultPaymentDetails paymentDetails;
    public StatsDetails statsDetails;
//    public transactionInfoResultStornoDetails stornoDetails;

    public void internalInit()
    {
        request = new TransactionInfoResultRequest();
        connection = new TransactionInfoResultConnection();
        enduser = new EndUser();
        saleData = new SaleData();
        paymentDetails = new TransactionInfoResultPaymentDetails();
        statsDetails = new StatsDetails();
    }

    private boolean isReady()
    {
        if (request.result.equalsIgnoreCase("1"))
        {
            return true;
        }
        return false;
    }

    public String getPaymentState()
    {
        if (!isReady())
        {
            return "NOT-READY";
        }

        return paymentDetails.stateName;
    }
    public boolean isPaid()
    {
        return (paymentDetails.stateName.equalsIgnoreCase("PAID"));
    }
    public boolean isPending()
    {
        boolean returner = false;
        if (paymentDetails.stateName.equalsIgnoreCase("PENDING")) {
            returner = true;
        }
        if (paymentDetails.stateName.equalsIgnoreCase("VERIFY"))
        {
            returner = true;
        }
        return returner;
    }
    public boolean isCanceled()
    {
        return (paymentDetails.stateName.equalsIgnoreCase("CANCEL"));
    }

}
