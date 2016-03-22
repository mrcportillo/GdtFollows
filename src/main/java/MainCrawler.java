import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;

/**
 * Created by juan.portillo on 29/12/15.
 */

public class MainCrawler {
    private static final String GDTURL = "http://www.grandt.clarin.com/grandt/ini.htm?idPlataforma=1";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36";
    private static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.110.2.251",3128));

    public static void main(String[] args) {
        try {
            System.out.println(Util.getChangesRank(Util.getChanges(Util.mapper(httpRequest(getSessionId(), "123123")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String  getSessionId() throws IOException {
        String dataParameters = "password=3569o8O2&nroDocumento=35690802&tipoDocumento=1";
        byte[] postData = dataParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = new URL(GDTURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(PROXY);
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        connection.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(postData);
        String headerName;
        String cookie = null;
        CharSequence sessionSec = "JSESSIONID";
        for (int i = 1; (headerName = connection.getHeaderFieldKey(i)) != null; i++) {
            if (headerName.equals("Set-Cookie")
                    && connection.getHeaderField(i).contains(sessionSec)) {
                cookie = connection.getHeaderField(i).split(";")[0];
            }
        }
        return cookie;
    }

    public static String httpRequest(String cookie, String remCSFR) throws IOException {
            URL url = new URL("http://www.grandt.clarin.com/grandt/timeline.htm?_action=init&_r=4010361458240683848&csrf=" + remCSFR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(PROXY);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Proxy-Connection", "keep-alive");
            connection.setRequestProperty("host", "www.grandt.clarin.com");
            connection.setRequestProperty("Cookie", cookie);
            connection.connect();

            if (connection.getResponseCode() == 500) {
                BufferedReader es = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream()));
                return httpRequest(cookie, Util.getCSFRCode(IOUtils.toString(es)));
            }
            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                return IOUtils.toString(in);
            }
        return null;
    }
}

