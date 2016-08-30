package nl.pay.sdk.transactioninfo;

public class InvoiceAddress {
    public String initials = "";
    public String lastName = "";
    public String gender = "";
    public String streetName = "";
    public String streetNumber = "";
    public String zipCode = "";
    public String city = "";
    public String countryCode = "";

    public void setInitials(String val) {
        initials = val;
    }

    public void setLastName(String val) {
        lastName = val;
    }

    public void setGender(String val) {
        gender = val;
    }

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
