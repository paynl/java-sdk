package nl.pay.sdk.servicelist;


public class Merchant {
    public String id;
    public String name;
    public String publicName;
    public int state;

    /**
     * getId - Return the id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * getName - Return the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * getPublicName - Return the public available name
     * @return th public available name
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * getState - Return if this is currently enabled or not.
     * @return true if this is enabled for use
     */
    public boolean getState() {
        return (state==1);
    }
}
