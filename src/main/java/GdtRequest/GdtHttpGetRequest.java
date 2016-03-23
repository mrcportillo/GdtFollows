package GdtRequest;

import Util.Util;
import org.apache.commons.io.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by juan.portillo on 23/03/16.
 */
public class GdtHttpGetRequest {
    private HttpURLConnection connection;

    public GdtHttpGetRequest (String baseUrl, String sessionId) throws IOException {
        connection.setRequestMethod(RequestEnum.GET.getText());
        connection.setRequestProperty(RequestEnum.USER_AGENT_KEY.getText(), RequestEnum.USER_AGENT.getText());
        connection.setRequestProperty(RequestEnum.ACCEPT_KEY.getText(), RequestEnum.ACCEPT_VALUE.getText());
        connection.setRequestProperty(RequestEnum.PROXY_CONNECTION_KEY.getText(), RequestEnum.PROXY_CONNECTION_VALUE.getText());
        connection.setRequestProperty(RequestEnum.HOST.getText(), baseUrl);
        connection.setRequestProperty(RequestEnum.COOKIE_KEY.getText(), sessionId);
    }

    public BufferedReader makeChangesRequest(String baseUrl, String urlRequest, String remCSFR) throws IOException {
        URL url = new URL(baseUrl + urlRequest + remCSFR);
        connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        if (connection.getResponseCode() == 500) {
            BufferedReader es = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            return makeChangesRequest(baseUrl, urlRequest, Util.getCSFRCode(IOUtils.toString(es)));
        }
        if (connection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            return in;
        }
        return null;
    }

    public BufferedReader makeChangesRequest(String baseUrl, String urlRequest, String remCSFR, Proxy proxy) throws IOException {
        URL url = new URL(baseUrl + urlRequest + remCSFR);
        connection = (HttpURLConnection) url.openConnection(proxy);
        connection.connect();
        if (connection.getResponseCode() == 500) {
            BufferedReader es = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            return makeChangesRequest(baseUrl, urlRequest, Util.getCSFRCode(IOUtils.toString(es)));
        }
        if (connection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            return in;
        }
        return null;
    }

    public String getJsonResponse(BufferedReader bufferedReader) throws IOException {
        return IOUtils.toString(bufferedReader);
    }
}
