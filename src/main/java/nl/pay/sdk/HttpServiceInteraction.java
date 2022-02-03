package nl.pay.sdk;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


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
                String auth = urlObj.getUserInfo();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
                String basicAuth = "Basic " + new String(encodedAuth);
                urlConn.setRequestProperty("Authorization", basicAuth);
            }
            wr = new OutputStreamWriter(urlConn.getOutputStream());
            wr.write(paramData);
            wr.flush();

            StringBuffer stringBuffer = new StringBuffer();
            if (urlConn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            }
            else if (urlConn.getResponseCode() >= 400 && urlConn.getResponseCode() < 500){
                // Return manually crafted json
                // Really sorry about this, but I want something that resembles generic solutions for errors
                String response =
                        "{\"request\":{\"result\":\"0\",\"errorId\":\"" + urlConn.getResponseCode() + "\",\"errorMessage\":\""+ urlConn.getResponseMessage() +"\"}}";
                return response;
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
            try {
                br.close();
            }
            catch(Exception exception)
            {
                // Don't do anything as it's probably closed already.
            }
        }
    }
}
