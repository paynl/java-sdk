package nl.pay.sdk.transactioninfo;

public class Address {
    public String streetName = "";
    public String streetNumber = "";
    public String zipCode = "";
    public String city = "";
    public String countryCode = "";

    public void setStreetName(String val) {
        streetName = val;
    }

    public void setStreetNumber(String val) {
        streetNumber = val;
    }

    public void setZipCode(String val) {
        zipCode = val;
    }

    public void setCity(String val) {
        city = val;
    }

    public void setCountryCode(String val) {
        countryCode = val;
    }
}
