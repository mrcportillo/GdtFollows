import GdtRequest.GdtHttpGetRequest;
import GdtRequest.GdtHttpPostRequest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Created by juan.portillo on 29/12/15.
 */

public class MainCrawler {
    private static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.110.2.251",3128));

    public static void main(String[] args) {
        try {
            GdtHttpPostRequest gdtHttpPostRequest =
                    new GdtHttpPostRequest(UrlEnum.BASE_URL.getText(),
                    UrlEnum.POST_URL.getText(), PROXY);
            gdtHttpPostRequest.makeLogInRequest("","");

            GdtHttpGetRequest gdtHttpGetRequest =
                    new GdtHttpGetRequest(UrlEnum.BASE_URL.getText(),
                            gdtHttpPostRequest.getSessionId());

            gdtHttpGetRequest.getJsonResponse(gdtHttpGetRequest.makeChangesRequest(
                    UrlEnum.BASE_URL.getText(),
                    UrlEnum.POST_URL.getText(),
                    "321654"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

