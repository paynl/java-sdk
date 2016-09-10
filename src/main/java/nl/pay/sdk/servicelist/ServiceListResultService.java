package nl.pay.sdk.servicelist;


public class ServiceListResultService {
    public String id;
    public int state;
    public String name;
    public String description;
    public String publication;
    public String basePath;
    public int module;
    public int subModule;
    public String successUrl;
    public String errorUrl;

    /**
     * getId
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * getState - returns the current state
     * @return true if enabled
     */
    public boolean getState() {
        return (1==state);
    }

    /**
     * getName - returns the name of the service
     * @return the name of the service
     */
    public String getName() {
        return name;
    }

    /**
     * getDescription - returns the description of the service
     * @return the description of the service
     */
    public String getDescription() {
        return description;
    }

    /**
     * getPublication
     * @return the publication
     */
    public String getPublication() {
        return publication;
    }

    /**
     * getBasePath
     * @return the base path
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * getModule
     * @return the internal module id in Pay.nl
     */
    public int getModule() {
        return module;
    }

    /**
     * getSubModule
     * @return the internal submodule id in Pay.nl
     */
    public int getSubModule() {
        return subModule;
    }

    /**
     * getSuccessUrl
     * @return the statically configured success url (will probably be empty)
     */
    public String getSuccessUrl() {
        return successUrl;
    }

    /**
     * getErrorUrl
     * @return the statically configured error url (will probably be empty)
     */
    public String getErrorUrl() {
        return errorUrl;
    }

}