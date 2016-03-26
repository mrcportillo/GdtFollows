package GdtRequest;
/**
 * Created by juan.portillo on 23/03/16.
 */
public enum RequestEnum {
    USER_AGENT("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36"),
    GET("GET"),
    USER_AGENT_KEY("User-Agent"),
    ACCEPT_KEY("Accept"),
    ACCEPT_VALUE("*/*"),
    PROXY_CONNECTION_KEY("Proxy-Connection"),
    PROXY_CONNECTION_VALUE("keep-alive"),
    HOST("host"),
    POST("POST"),
    CONTENT_TYPE_KEY("Content-Type"),
    CONTENT_TYPE_VALUE("application/x-www-form-urlencoded"),
    CHARSET_KEY("charset"),
    CHARSET_VALUE("utf-8"),
    COOKIE_KEY("Cookie");

    private final String text;

    RequestEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
