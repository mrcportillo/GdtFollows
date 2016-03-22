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
    private static final String JSONSTRING = "{\"timeline\":[{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:16:11 AM\",\"fechaMillis\":1458281771707,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a De Paul, Rodrigo.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":4966737,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:07:47 PM\",\"fechaMillis\":1458324467468,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Sand, Jos\\u0026eacute;.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5117701,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:08:48 PM\",\"fechaMillis\":1458324528329,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Vittor, Sergio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5117731,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:10:51 PM\",\"fechaMillis\":1458324651449,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Malcorra, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5118964,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:21:34 PM\",\"fechaMillis\":1458328894485,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Crivelli, Federico.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5154081,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:22:20 PM\",\"fechaMillis\":1458328940457,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Olave, Juan Carlos.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155151,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:23:18 PM\",\"fechaMillis\":1458328998095,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a G\\u0026oacute;mez, Jos\\u0026eacute; Luis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155184,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:23:50 PM\",\"fechaMillis\":1458329030451,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bogino, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155857,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:25:03 PM\",\"fechaMillis\":1458329103636,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Soto, Alexis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155884,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:27:10 PM\",\"fechaMillis\":1458329230354,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Romat, Nicol\\u0026aacute;s.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5156837,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:28:23 PM\",\"fechaMillis\":1458329303035,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Cavallaro, Juan I..\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5158221,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:28:55 PM\",\"fechaMillis\":1458329335626,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5158238,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:29:16 PM\",\"fechaMillis\":1458329356781,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Garc\\u0026iacute;a, Santiago.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159101,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:30:57 PM\",\"fechaMillis\":1458329457355,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Lo Celso, Giovani.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159908,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:31:34 PM\",\"fechaMillis\":1458329494426,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Abila, Ram\\u0026oacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159928,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:41:55 PM\",\"fechaMillis\":1458330115339,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Rigoni, Emiliano.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5165292,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:42:33 PM\",\"fechaMillis\":1458330153243,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Buffarini, Julio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5166462,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:44:10 PM\",\"fechaMillis\":1458330250263,\"idTipo\":3,\"mensaje\":\"{user} modificó su capitán\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/miEquipo.htm\"},\"id\":5167358,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:46:20 PM\",\"fechaMillis\":1458330380060,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bou, Walter.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5168651,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:48:19 PM\",\"fechaMillis\":1458330499796,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Ruben, Marco.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5168698,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:48:13 PM\",\"fechaMillis\":1458334093561,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Cavallaro, Juan I..\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204239,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:48:39 PM\",\"fechaMillis\":1458334119465,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Adv\\u0026iacute;ncula, Luis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204568,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:49:06 PM\",\"fechaMillis\":1458334146833,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Sand, Jos\\u0026eacute;.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204594,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:49:24 PM\",\"fechaMillis\":1458334164196,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Malcorra, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5205309,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:54:38 PM\",\"fechaMillis\":1458334478943,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5208129,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:56:54 PM\",\"fechaMillis\":1458334614652,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Schunke, Jonatan.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5209817,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:03:20 PM\",\"fechaMillis\":1458335000536,\"idTipo\":3,\"mensaje\":\"{user} modificó su capitán\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/miEquipo.htm\"},\"id\":5213586,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:04:09 PM\",\"fechaMillis\":1458335049013,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Torrico, Sebasti\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5214282,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:38:51 PM\",\"fechaMillis\":1458337131063,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Rodr\\u0026iacute;guez, Maxi .\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5237049,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:47:17 PM\",\"fechaMillis\":1458337637195,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5243327,\"cssClass\":\"cambios\"}],\"user\":{\"replCountMeSiguen\":3,\"ultimaLectura\":\"Mar 21, 2016 12:35:44 PM\",\"id\":551978,\"replCamiseta\":\"2,2,33,ff00cc,4\",\"visible\":true,\"replNombreApellido\":\"juan marcos portillo\",\"replCountSigo\":3,\"replNombreEquipo\":\"estupendeja team\"}}";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36";
    private static final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.110.2.251",3128));

    public static void main(String[] args) {
        try {
            Util.getChangesRank(Util.getChanges(Util.mapper(httpRequest(getSessionId(),"123123"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String  getSessionId() throws IOException {
        String dataParameters = "password=3569o8O2&nroDocumento=35690802&tipoDocumento=1";
        byte[] postData = dataParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = new URL(GDTURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
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
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
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
                httpRequest(cookie, Util.getCSFRCode(IOUtils.toString(es)));
            } else {
                if (connection.getResponseCode() == 200) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    return IOUtils.toString(in);
                }
            }
        return null;
    }
}

