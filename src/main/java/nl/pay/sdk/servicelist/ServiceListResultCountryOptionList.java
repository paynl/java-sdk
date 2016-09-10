package nl.pay.sdk.servicelist;

import java.util.ArrayList;
import java.util.List;

public class ServiceListResultCountryOptionList {
    public List<Country> country = new ArrayList<Country>();

    /**
     * getCountries
     * Gets list of countries.
     * @return list of countries
     */
    public List<Country> getCountries() {
        return country;
    }
}
