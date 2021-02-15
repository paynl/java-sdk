package nl.pay.sdk.servicelist;

public class PaymentOptionSub {
    public int id;
    public String name;
    public String visibleName;
    public String image;
    public int state;

    /**
     * getId - Returns the id of this bank
     * @return The bank id
     */
    public int getId() {
        return id;
    }

    /**
     * getName - Returns the name of this bank
     * @return The name of this bank
     */
    public String getName() {
        return name;
    }

    /**
     * getVisibleName - Returns the visible name for this bank
     * @return The visible name
     */
    public String getVisibleName() {
        return visibleName;
    }

    /**
     * @deprecated Has been replaced by getImage()
     * @return image
     */
    public String getImg(){ return image; }

    public String getImage() {
        return image;
    }

    /**
     * @deprecated Has been removed, will now return empty string
     * @return
     */
    public String getPath() {
        return "";
    }

    public int getState() {
        return state;
    }
}
