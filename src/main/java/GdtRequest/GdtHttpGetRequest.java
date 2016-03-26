package GdtRequest;

import Exceptions.ExpiredSessionException;
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

    public BufferedReader makeChangesRequest(String baseUrl, String urlRequest, String remCSFR, String sessionId)
         throws IOException, ExpiredSessionException {
        URL url = new URL(baseUrl + urlRequest + remCSFR);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(RequestEnum.GET.getText());
        connection.setRequestProperty(RequestEnum.COOKIE_KEY.getText(), sessionId);
        connection.setRequestProperty(RequestEnum.USER_AGENT_KEY.getText(), RequestEnum.USER_AGENT.getText());
        connection.setRequestProperty(RequestEnum.ACCEPT_KEY.getText(), RequestEnum.ACCEPT_VALUE.getText());
        connection.setRequestProperty(RequestEnum.PROXY_CONNECTION_KEY.getText(), RequestEnum.PROXY_CONNECTION_VALUE.getText());
        connection.setRequestProperty(RequestEnum.HOST.getText(), baseUrl);
        connection.connect();
        if (connection.getResponseCode() == 500) {
            BufferedReader es = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            return makeChangesRequest(baseUrl, urlRequest, Util.getCSFRCode(IOUtils.toString(es)), sessionId);
        }
        if (connection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            return in;
        }
        if (connection.getResponseCode() == 403) {
            throw new ExpiredSessionException(connection.getErrorStream());
        }
        return null;
    }

    public BufferedReader makeChangesRequest(String baseUrl, String urlRequest, String remCSFR, Proxy proxy, String sessionId)
         throws IOException, ExpiredSessionException {
        URL url = new URL(baseUrl + urlRequest + remCSFR);
        connection = (HttpURLConnection) url.openConnection(proxy);
        connection.setRequestMethod(RequestEnum.GET.getText());
        connection.setRequestProperty(RequestEnum.USER_AGENT_KEY.getText(), RequestEnum.USER_AGENT.getText());
        connection.setRequestProperty(RequestEnum.ACCEPT_KEY.getText(), RequestEnum.ACCEPT_VALUE.getText());
        connection.setRequestProperty(RequestEnum.PROXY_CONNECTION_KEY.getText(), RequestEnum.PROXY_CONNECTION_VALUE.getText());
        connection.setRequestProperty(RequestEnum.HOST.getText(), baseUrl);
        connection.setRequestProperty(RequestEnum.COOKIE_KEY.getText(), sessionId);
        connection.connect();
        if (connection.getResponseCode() == 500) {
            BufferedReader es = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            return makeChangesRequest(baseUrl, urlRequest, Util.getCSFRCode(IOUtils.toString(es)), proxy, sessionId);
        }
        if (connection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            return in;
        }
        if (connection.getResponseCode() == 403) {
            throw new ExpiredSessionException(connection.getErrorStream());
        }
        return null;
    }

    public String getJsonResponse(BufferedReader bufferedReader) throws IOException {
        return IOUtils.toString(bufferedReader);
    }
}
