package nl.pay.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class Helper {

    public static String addToUrl(String key, String val) {
        try {
            String data = URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(val, "UTF-8");
            return data;
        } catch (UnsupportedEncodingException ex) // Only process this exception, all others should be allowed to continue
        {
            return "";
        }

    }
}
