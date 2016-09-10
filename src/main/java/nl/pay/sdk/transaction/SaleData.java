package nl.pay.sdk.transaction;

import java.util.ArrayList;
import java.util.List;

public class SaleData {
    public String invoiceDate = "";
    public String deliveryDate = "";
    public List<Product> orderData = new ArrayList<Product>();

    /**
     * setInvoiceDate
     * Set the invoice date, format (DD-MM-YYYY)
     * @param val invoice date as string in format DD-MM-YYYY
     */
    public void setInvoiceDate(String val) {
        invoiceDate = val;
    }

    /**
     * setDeliveryDate
     * Set the delivery date, format (DD-MM-YYYY)
     * @param val delivery date as string in format DD-MM-YYYY
     */
    public void setDeliveryDate(String val) {
        deliveryDate = val;
    }

    /**
     * addProduct
     * @param val add product object
     */
    public void addProduct(Product val) {
        orderData.add(val);
    }
}
