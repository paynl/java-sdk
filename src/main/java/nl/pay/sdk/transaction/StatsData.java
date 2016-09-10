package nl.pay.sdk.transaction;

public class StatsData {
    public Integer promoterId = 0;
    public String info = "";
    public String tool = "";
    public String extra1 = "";
    public String extra2 = "";
    public String extra3 = "";

    /**
     * @deprecated
     * @param promoterId
     */
    public void setPromoterId(Integer promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * @deprecated
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @deprecated
     * @param tool
     */
    public void setTool(String tool) {
        this.tool = tool;
    }

    /**
     * setExtra1
     * A space which is listed in the statistical systems for you to set with your own data.
     * Within the API and web systems, you can group by this, so think carefully about this.
     * @param extra1 Please read description
     */
    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    /**
     * @deprecated
     * @param extra2
     */
    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    /**
     * @deprecated
     * @param extra3
     */
    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }
}
