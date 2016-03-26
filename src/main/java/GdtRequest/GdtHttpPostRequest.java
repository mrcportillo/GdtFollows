package GdtRequest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by juan.portillo on 23/03/16.
 */
public class GdtHttpPostRequest {

    private HttpURLConnection connection;
    private String sessionId;

    public GdtHttpPostRequest(String baseUrl, String gdtUrl, Proxy proxy) throws IOException {
        URL url = new URL(baseUrl + gdtUrl);
        connection = (HttpURLConnection) url.openConnection(proxy);
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod(RequestEnum.POST.getText());
        connection.setRequestProperty(RequestEnum.CONTENT_TYPE_KEY.getText(), RequestEnum.CONTENT_TYPE_VALUE.getText());
        connection.setRequestProperty(RequestEnum.CHARSET_KEY.getText(), RequestEnum.CHARSET_VALUE.getText());
    }

    public GdtHttpPostRequest(String baseUrl, String gdtUrl) throws IOException {
        URL url = new URL(baseUrl + gdtUrl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod(RequestEnum.POST.getText());
        connection.setRequestProperty(RequestEnum.CONTENT_TYPE_KEY.getText(), RequestEnum.CONTENT_TYPE_VALUE.getText());
        connection.setRequestProperty(RequestEnum.CHARSET_KEY.getText(), RequestEnum.CHARSET_VALUE.getText());
    }

    public void makeLogInRequest(String password, String nroDocumento) throws IOException {
        String dataParameters = "password=" + password + "&nroDocumento=" + nroDocumento
                + "&tipoDocumento=1";
        byte[] postData = dataParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        connection.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(postData);
    }

    public void setSessionId() {
        String headerName;
        CharSequence sessionSec = "JSESSIONID";
        for (int i = 1; (headerName = connection.getHeaderFieldKey(i)) != null; i++) {
            if (headerName.equals("Set-Cookie")
                    && connection.getHeaderField(i).contains(sessionSec)) {
                sessionId = connection.getHeaderField(i).split(";")[0];
            }
        }
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    public String getSessionId() {
        return sessionId;
    }

}
