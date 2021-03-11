package nl.pay.sdk.refund;

public class TransactionResultFailedTransaction {
    public String orderId;
    public int amount;
    public int amountRefunded;
    public String voucherNumber;
    public String bankaccountNumber;
    public String reason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(int amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getBankaccountNumber() {
        return bankaccountNumber;
    }

    public void setBankaccountNumber(String bankaccountNumber) {
        this.bankaccountNumber = bankaccountNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
