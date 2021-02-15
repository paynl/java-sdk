package nl.pay.sdk.transaction;

public class Product {
    /** PRODUCT_TYPE_ARTICLE string Normal retail article */
    public static final String PRODUCT_TYPE_ARTICLE = "ARTICLE";
    /** PRODUCT_TYPE_ARTICLE_H string Retail product with high fraud risk, easy to resell (mobile phones, tablets, laptops, juwelery) */
    public static final String PRODUCT_TYPE_ARTICLE_H = "ARTICLE_H";
    /** PRODUCT_TYPE_CREDIT string Credit of a previous payment */
    public static final String PRODUCT_TYPE_CREDIT = "CREDIT";
    /** PRODUCT_TYPE_CRYPTO string Digital currency like BitCoin, Ethereum or other altcoins */
    public static final String PRODUCT_TYPE_CRYPTO = "CRYPTO";
    /** PRODUCT_TYPE_DISCOUNT string Discount for the total order */
    public static final String PRODUCT_TYPE_DISCOUNT = "DISCOUNT";
    /** PRODUCT_TYPE_DOWNLOAD string Digital transfer of a file (photo, video, data) */
    public static final String PRODUCT_TYPE_DOWNLOAD = "DOWNLOAD";
    /** PRODUCT_TYPE_EMONEY string Vouchers that can be redeemded at multiple platforms or potentially be resold (eg. iTunes/steam/paysafecard etc.) - open loop (high risk) */
    public static final String PRODUCT_TYPE_EMONEY = "EMONEY";
    /** PRODUCT_TYPE_GIFTCARD string Card that represents a value for a (group of) merchant(s) - closed loop (medium risk) */
    public static final String PRODUCT_TYPE_GIFTCARD = "GIFTCARD";
    /** PRODUCT_TYPE_HANDLING string Costs that are added for taking care of the order */
    public static final String PRODUCT_TYPE_HANDLING = "HANDLING";
    /** PRODUCT_TYPE_IDENTITY string Verification payment to check identity or account/name verification. */
    public static final String PRODUCT_TYPE_IDENTITY = "IDENTITY";
    /** PRODUCT_TYPE_INVOICE string Payment of an invoice (products or service must already be delivered) */
    public static final String PRODUCT_TYPE_INVOICE = "INVOICE";
    /** PRODUCT_TYPE_PAYMENT string Payment fees */
    public static final String PRODUCT_TYPE_PAYMENT = "PAYMENT";
    /** PRODUCT_TYPE_ROUNDING string An extra order line added by PAY. if the total amount does not match the total of the product lines */
    public static final String PRODUCT_TYPE_ROUNDING = "ROUNDING";
    /** PRODUCT_TYPE_SHIPPING string Costs for shipment */
    public static final String PRODUCT_TYPE_SHIPPING = "SHIPPING";
    /** PRODUCT_TYPE_TICKET string Ticket for events, festivals or theaters */
    public static final String PRODUCT_TYPE_TICKET = "TICKET";
    /** PRODUCT_TYPE_TOPUP string Add funds to an account (owned by a person or company) NOTE: if you sell anonymous or temporary accounts please use EMONEY */
    public static final String PRODUCT_TYPE_TOPUP = "TOPUP";
    /** PRODUCT_TYPE_VIRTUAL string Digital assets, stored on the server of the merchant (eg. in game puchases) */
    public static final String PRODUCT_TYPE_VIRTUAL = "VIRTUAL";
    /** PRODUCT_TYPE_VOUCHER string Voucher for a free article or discount for next order */
    public static final String PRODUCT_TYPE_VOUCHER = "VOUCHER";

    public String productId = "";
    public String description = "";
    public Integer price = 0;
    public Integer quantity = 0;
    public String vatCode = "";
    public String type = "ARTICLE"; // default value

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

    /**
     * setType
     * This can be one of the class static constants (starting with PRODUCT_TYPE_).
     * This resolves to a string value, which is passed on.
     * @param val Product type
     */
    public void setType(String val) { type = val; }
}
