package nl.pay.sdk.transaction;

public class Address {
    public String streetName = "";
    public String streetNumber = "";
    public String zipCode = "";
    public String city = "";
    public String countryCode = "NL";

    /**
     * setStreetName
     * Set the name of the street for product delivery
     * @param val name of the street
     */
    public void setStreetName(String val) {
        streetName = val;
    }

    /**
     * setStreetNumber
     * Set the number of the house in the street (for product delivery)
     * @param val number of the house
     */
    public void setStreetNumber(String val) {
        streetNumber = val;
    }

    /**
     * setZipCode
     * Set the entire ZIP code for the address
     * @param val (entire) ZIP code
     */
    public void setZipCode(String val) {
        zipCode = val;
    }

    /**
     * setCity
     * Set the name of the city for this address
     * @param val city
     */
    public void setCity(String val) {
        city = val;
    }

    /**
     * setCountryCode
     * Set the ISO 3166-1 (2 char) country code for this address
     * @param val ISO3166-1 (2 char) country code
     */
    public void setCountryCode(String val) {
        countryCode = val;
    }
}
