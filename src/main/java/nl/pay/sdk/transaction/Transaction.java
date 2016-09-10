package nl.pay.sdk.transaction;

public class Transaction {
    public String currency = "EUR";
    public Integer costsVat = 0;
    public String orderExchangeUrl = "";
    //	public String expireDate = "";
//	public String sendReminderEmail = "";
//	public String reminderMailTemplatedId = "";
    public String description = "";
    public Integer enduserId = 0;

    /**
     * getCurrency
     * @return the current currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * setCurrency
     * Set a currency (ISO 4217 format)
     * @param currency currency in ISO 4217 format
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * getCostsVat
     * @return Vat costs
     */
    public Integer getCostsVat() {
        return costsVat;
    }

    /**
     * setCostsVat
     * Set costs of vat in cents
     * @param costsVat vat in cents
     */
    public void setCostsVat(Integer costsVat) {
        this.costsVat = costsVat;
    }

    /**
     * getOrderExchangeUrl
     * @return exchange URL
     */
    public String getOrderExchangeUrl() {
        return orderExchangeUrl;
    }

    /**
     * setOrderExchangeURL
     * Set the exchange URL for the transaction where you can receive callbacks from Pay.nl.
     * DO NOTE: This URL should be available from the internet.
     * @param orderExchangeUrl exchange URL
     */
    public void setOrderExchangeUrl(String orderExchangeUrl) {
        this.orderExchangeUrl = orderExchangeUrl;
    }

//	public String getExpireDate() {
//		return expireDate;
//	}
//
//	public void setExpireDate(String expireDate) {
//		this.expireDate = expireDate;
//	}
//
//	public String getSendReminderEmail() {
//		return sendReminderEmail;
//	}
//
//	public void setSendReminderEmail(String sendReminderEmail) {
//		this.sendReminderEmail = sendReminderEmail;
//	}
//
//	public String getReminderMailTemplatedId() {
//		return reminderMailTemplatedId;
//	}
//
//	public void setReminderMailTemplatedId(String reminderMailTemplatedId) {
//		this.reminderMailTemplatedId = reminderMailTemplatedId;
//	}

    /**
     * getDescription
     * @return description of transaction
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription
     * Description of transaction listed on statement for enduser (max 32 vars)
     * @param description description for enduser
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @deprecated
     * @return
     */
    public Integer getEnduserId() {
        return enduserId;
    }

    /**
     * @deprecated
     * @param enduserId
     */
    public void setEnduserId(Integer enduserId) {
        this.enduserId = enduserId;
    }
}
