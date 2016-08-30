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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getCostsVat() {
        return costsVat;
    }

    public void setCostsVat(Integer costsVat) {
        this.costsVat = costsVat;
    }

    public String getOrderExchangeUrl() {
        return orderExchangeUrl;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnduserId() {
        return enduserId;
    }

    public void setEnduserId(Integer enduserId) {
        this.enduserId = enduserId;
    }
}
