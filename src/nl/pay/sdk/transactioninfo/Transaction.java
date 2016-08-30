package nl.pay.sdk.transactioninfo;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String currency = "";
    private Integer costsVat = 0;
    private List<Integer> excludeCosts = new ArrayList<Integer>();
    private String orderExchangeUrl = "";
    private String expireDate = "";
    private String sendReminderEmail = "";
    private String reminderMailTemplatedId = "";

    public void setCurrency(String val) {
        currency = val;
    }

    public void setCostsVat(Integer val) {
        costsVat = val;
    }

    public void addExcludeCosts(Integer val) {
        excludeCosts.add(val);
    }

    public void setOrderExchangeUrl(String val) {
        orderExchangeUrl = val;
    }

    public void setExpireDate(String val) {
        expireDate = val;
    }

    public void setSendReminderEmail(String val) {
        sendReminderEmail = val;
    }

    public void setReminderMailTemplateId(String val) {
        reminderMailTemplatedId = val;
    }
}
