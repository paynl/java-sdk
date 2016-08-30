package nl.pay.sdk.transactioninfo;

public class Product {
    public String productId = "";
    public String description = "";
    public Integer price = 0;
    public Integer quantity = 0;
    public String vatCode = "";

    public void setProductId(String val) {
        productId = val;
    }

    public void setDescription(String val) {
        description = val;
    }

    public void setPrice(Integer val) {
        price = val;
    }

    public void setQuantity(Integer val) {
        quantity = val;
    }

    public void setVatCode(String val) {
        vatCode = val;
    }
}
