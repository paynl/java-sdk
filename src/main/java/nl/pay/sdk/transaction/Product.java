package nl.pay.sdk.transaction;

public class Product {
    public String productId = "";
    public String description = "";
    public Integer price = 0;
    public Integer quantity = 0;
    public String vatCode = "";

    /**
     * setProductId
     * Set your internal product id (or SKU)
     * @param val SKU
     */
    public void setProductId(String val) {
        productId = val;
    }

    /**
     * setDescription
     * Set the description of the product (title or name)
     * @param val description
     */
    public void setDescription(String val) {
        description = val;
    }

    /**
     * setPrice
     * Set the price for this line in Eurocents (note, the final amount does not change, this is administrative)
     * @param val price of line
     */
    public void setPrice(Integer val) {
        price = val;
    }

    /**
     * setQuantity
     * @param val quantity of item
     */
    public void setQuantity(Integer val) {
        quantity = val;
    }

    /**
     * setVatCode
     * This can be eighter (H)igh / (L)ow / (N)one. Percentages are NOT ACCEPTED
     * @param val H/L/N (see description for details)
     */
    public void setVatCode(String val) {
        vatCode = val;
    }
}
