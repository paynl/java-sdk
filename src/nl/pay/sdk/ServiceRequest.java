package nl.pay.sdk;

public interface ServiceRequest {
    public void setServiceId(String val);

    public void setToken(String val);

    public String startRequest();

}
