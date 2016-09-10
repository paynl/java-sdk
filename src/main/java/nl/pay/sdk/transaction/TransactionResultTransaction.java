package nl.pay.sdk.transaction;

public class TransactionResultTransaction {
    public String transactionId;
    public String paymentURL;
    public String popupAllowed;
    public String paymentReference;

    /**
     * getTransactionId
     * @return the transaction id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * getPaymentURL
     * @return the payment URL the enduser should go to, to complete the transaction
     */
    public String getPaymentURL() {
        return paymentURL;
    }

    /**
     * isPopupAllowed
     * @return true if popups are allowed for this payment method
     */
    public boolean isPopupAllowed() {
        return (popupAllowed.equalsIgnoreCase("1"));
    }

    /**
     * getPaymentReference
     * @return payment reference
     */
    public String getPaymentReference() {
        return paymentReference;
    }
}
