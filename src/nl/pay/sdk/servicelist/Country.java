package nl.pay.sdk.servicelist;

import java.util.ArrayList;
import java.util.List;

public class Country {
    public String id;
    public String name;
    public String visibleName;
    public int in_eu;
    public String img;
    public String path;
    public List<PaymentOptionList> PaymentOptionList = new ArrayList<PaymentOptionList>();
}
