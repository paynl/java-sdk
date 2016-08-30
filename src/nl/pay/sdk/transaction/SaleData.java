package nl.pay.sdk.transaction;

import java.util.ArrayList;
import java.util.List;

public class SaleData {
    public String invoiceDate = "";
    public String deliveryDate = "";
    public List<Product> orderData = new ArrayList<Product>();

    public void setInvoiceDate(String val) {
        invoiceDate = val;
    }

    public void setDeliveryDate(String val) {
        deliveryDate = val;
    }

    public void addProduct(Product val) {
        orderData.add(val);
    }
}
