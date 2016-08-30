package nl.pay.sdk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpServiceInteraction {
    private String url = "";
    private String paramData = "";

    public void setURL(String val) {
        url = val;
    }

    public void setParamData(String val) {
        paramData = val;
    }

    public String getURL() {
        return url;
    }

    public String getResponse() throws Exception {
        BufferedReader br = null;
        OutputStreamWriter wr = null;
        try {
            URL urlObj = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlObj.openConnection();
//			urlConn.setRequestMethod("GET");
            urlConn.setDoOutput(true);
            if (urlObj.getUserInfo() != null) {
                String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(urlObj.getUserInfo().getBytes());
                urlConn.setRequestProperty("Authorization", basicAuth);
            }
            wr = new OutputStreamWriter(urlConn.getOutputStream());
            wr.write(paramData);
            wr.flush();

            StringBuffer stringBuffer = new StringBuffer();
            if (urlConn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));
            }


            String strResponse;
            while ((strResponse = br.readLine()) != null) {
                stringBuffer.append(strResponse);
            }
            return stringBuffer.toString();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        } finally {
            wr.close();
            br.close();
        }
    }
}
