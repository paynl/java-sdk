package nl.pay.sdk.servicelist;

public class PaymentOptionList {
    public int id;
    public String name;
    public String visibleName;
    public String img;
    public String path;
    public int state;
    public int useOnlyInStore;
    public int paymentMethodId;

    /**
     * getId - Get Payment Option Id
     * (you need this to start the transaction, if you want to supply this)
     *
     * @return Payment Option Id
     */
    public int getId() {
        return id;
    }

    /**
     * getName - Return the name of the payment option
     * @return name of the payment option
     */
    public String getName() {
        return name;
    }

    /**
     * getVisibleName - Return the visible name of the payment option
     * @return Visible name of the payment option
     */
    public String getVisibleName() {
        return visibleName;
    }

    /**
     * getImg - Image of the payment option
     * You can use this, together with getPath to concat the entire image URL
     * @return image url part of the payment option
     */
    public String getImg() {
        return img;
    }

    /**
     * getPath - Path of the payment option image
     * @return path part of the url for the payment option
     */
    public String getPath() {
        return path;
    }

    /**
     * getState - Returns the state of the payment option
     * Will return true if the payment option is currently enabled / available.
     * @return is the payment option currently available
     */
    public boolean getState() {
        return (state == 1);
    }

    /**
     * getUseOnlyInStore - Returns if this payment option is only available in stores
     * Pay.nl offers in store payments as well as online payments, when this is true, the option is only available in the store.
     * @return Only available in stores
     */
    public boolean getUseOnlyInStore() {
        return (useOnlyInStore==1);
    }

    /**
     * getPaymentMethodId - Returns the payment method id
     * @return payment method id
     */
    public int getPaymentMethodId() {
        return paymentMethodId;
    }
}
