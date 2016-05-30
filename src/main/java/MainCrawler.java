import Exceptions.ExpiredSessionException;
import GdtRequest.GdtHttpGetRequest;
import GdtRequest.GdtHttpPostRequest;
import Util.Util;

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
                    UrlEnum.POST_URL.getText());
//            gdtHttpPostRequest.makeLogInRequest(args[0], args[1]);
            gdtHttpPostRequest.makeLogInRequest("3569o8O2", "35690802");
            gdtHttpPostRequest.setSessionId();
            GdtHttpGetRequest gdtHttpGetRequest =
                    new GdtHttpGetRequest();

            System.out.println(
                    Util.getChangesRank(
                            Util.getChanges(
                                    Util.mapper(
                                            gdtHttpGetRequest.getJsonResponse(
                                                    gdtHttpGetRequest.makeChangesRequest(
                                                            UrlEnum.BASE_URL.getText(),
                                                            UrlEnum.GET_URL.getText(),
                                                            "0068869",
                                                            gdtHttpPostRequest.getSessionId()))))));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExpiredSessionException e) {
            e.printStackTrace();
        }
    }


}
