package nl.pay.sdk.servicelist;

public class PaymentOptionSub {
    public int id;
    public String name;
    public String visibleName;
    public String img;
    public String path;
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

    public String getImg() {
        return img;
    }

    public String getPath() {
        return path;
    }

    public int getState() {
        return state;
    }
}
