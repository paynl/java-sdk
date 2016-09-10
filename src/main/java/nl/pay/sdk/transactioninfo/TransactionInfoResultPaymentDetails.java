package nl.pay.sdk.transactioninfo;

public class TransactionInfoResultPaymentDetails {
    public String amount;
    public String currencyAmount;
    public String paidAmount;
    public String paidCurrencyAmount;
    public int paidAttempts;
    public String description;
    public int state;
    public String stateName;
    public String stateDescription;
    public int paymentOptionId;
    public int paymentOptionSubId;
    public String identifierName = "";
    public String identifierPublic = "";
    public String identifierHash = "";

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public String getIdentifierPublic() {
        return identifierPublic;
    }

    public void setIdentifierPublic(String identifierPublic) {
        this.identifierPublic = identifierPublic;
    }

    public String getIdentifierHash() {
        return identifierHash;
    }

    public void setIdentifierHash(String identifierHash) {
        this.identifierHash = identifierHash;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(String currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaidCurrencyAmount() {
        return paidCurrencyAmount;
    }

    public void setPaidCurrencyAmount(String paidCurrencyAmount) {
        this.paidCurrencyAmount = paidCurrencyAmount;
    }

    public int getPaidAttempts() {
        return paidAttempts;
    }

    public void setPaidAttempts(int paidAttempts) {
        this.paidAttempts = paidAttempts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public int getPaymentOptionId() {
        return paymentOptionId;
    }

    public void setPaymentOptionId(int paymentOptionId) {
        this.paymentOptionId = paymentOptionId;
    }

    public int getPaymentOptionSubId() {
        return paymentOptionSubId;
    }

    public void setPaymentOptionSubId(int paymentOptionSubId) {
        this.paymentOptionSubId = paymentOptionSubId;
    }
}
