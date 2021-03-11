package nl.pay.sdk.refund;

import org.apache.commons.validator.GenericValidator;

public class Transaction {
    public String transactionId = "";
    public Integer amount = 0;
    public String description = "";
    public String processDate = "";
    public String exchangeUrl = "";
    public String currency = "EUR";

    /**
     * Return the Transaction ID
     * @return TransactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Set the Transaction ID
     * @param transactionId Transaction ID of related transaction
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Get the amount of refund in cents
     * @return amount (cents)
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Set the amount of refund in cents
     * @param amount (cents)
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Get the description of refund
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description for refund (max 32 chars)
     * @param description
     */
    public void setDescription(String description) {
        if (description.length() > 32)
        {
            this.description = description.substring(0,32);
        }
        else
        {
            this.description = description;
        }
    }

    /**
     * Get the date for processing the refund
     * @return string
     */
    public String getProcessDate() {
        return processDate;
    }

    /**
     * Set the date for processing the refund (dd-mm-YYYY)
     * @param processDate
     * @throws Exception
     */
    public void setProcessDate(String processDate) throws Exception {
        if (GenericValidator.isDate(processDate,"dd-MM-yyyy",true))
        {
            this.processDate = processDate;
        }
        else
        {
            throw new Exception("Invalid date, use dd-mm-yyyy");
        }
    }

    /**
     * Get the Exchange URL
     * @return URL
     */
    public String getExchangeUrl() {
        return exchangeUrl;
    }

    /**
     * Set the custom exchange URL
     * @param exchangeUrl
     */
    public void setExchangeUrl(String exchangeUrl) {
        this.exchangeUrl = exchangeUrl;
    }

    /**
     * Get the currency for the refund
     * @return
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Set the currency for the refund
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
