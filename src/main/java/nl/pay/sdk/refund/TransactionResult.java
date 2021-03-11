package nl.pay.sdk.refund;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionResult {
    public TransactionResultRequest request;
    public Integer amountRefunded;
    public String description;

    @SerializedName("refundedTransactions")
    public List<TransactionResultRefundedTransaction> refundedTransactions;
//    @SerializedName("failedTransactions")
//    public List<TransactionResultFailedTransaction> failedTransactions;


    public void internalInit()
    {
        request = new TransactionResultRequest();
//        refundedTransactions = new ArrayList<TransactionResultRefundedTransactions>();
//        failedTransactions = new ArrayList<TransactionResultFailedTransactions>();
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

    public Integer getAmountRefunded()
    {
        if (request == null)
        {
            internalInit();
        }
        if (!isReady())
        {
            return 0;
        }

        return amountRefunded;
    }
}
