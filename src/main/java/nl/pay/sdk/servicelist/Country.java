package nl.pay.sdk.servicelist;

import java.util.HashMap;
import java.util.Map;

public class Country {
    public String id;
    public String name;
    public String visibleName;
    public int in_eu;
    public String img;
    public String path;
    public Map<String,PaymentOption> paymentOptionList = new HashMap<String, PaymentOption>();

    /**
     * getId - get internal id of country
     * @return Internal ID of country
     */
    public String getId() {
        return id;
    }

    /**
     * getName - Get name of country
     * @return Name of country
     */
    public String getName() {
        return name;
    }

    /**
     * getVisibleName - Get visible name of country used in the system
     * @return Visible name of country
     */
    public String getVisibleName() {
        return visibleName;
    }

    /**
     * getIn_eu - Is the country in the EU according to Pay.nl
     * @return Is the country in the EU?
     */
    public boolean getIn_eu() {
        return (in_eu == 1);
    }

    /**
     * getImg - Get the image url part (usually part of the url for the flag for the country)
     * @return get the image url part
     */
    public String getImg() {
        return img;
    }

    /**
     * getPath - Get the path of the image url
     * @return path for the image url
     */
    public String getPath() {
        return path;
    }

    /**
     * getPaymentOptionList - Returns list of payment options
     * @return List of payment options
     */
    public Map<String,PaymentOption>  getPaymentOptionList() {
        return paymentOptionList;
    }
}
