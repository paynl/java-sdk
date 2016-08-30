package nl.pay.sdk.transaction;

public class StatsData {
    public Integer promoterId = 0;
    public String info = "";
    public String tool = "";
    public String extra1 = "";
    public String extra2 = "";
    public String extra3 = "";
//	public String transferData;

    public Integer getPromoterId() {
        return promoterId;
    }

    public void setPromoterId(Integer promoterId) {
        this.promoterId = promoterId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

//	public String getTransferData() {
//		return transferData;
//	}
//
//	public void setTransferData(String transferData) {
//		this.transferData = transferData;
//	}
}
