import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by juan.portillo on 29/12/15.
 */

public class MainCrawler {
    private static final String GDTURL = "http://www.grandt.clarin.com/html/login.html?s=3416991457982002901";
    private static final String JSONSTRING = "{\"timeline\":[{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:16:11 AM\",\"fechaMillis\":1458281771707,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a De Paul, Rodrigo.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":4966737,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:07:47 PM\",\"fechaMillis\":1458324467468,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Sand, Jos\\u0026eacute;.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5117701,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:08:48 PM\",\"fechaMillis\":1458324528329,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Vittor, Sergio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5117731,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":545857,\"visible\":true,\"replNombreApellido\":\"jose maria paez\",\"replNombreEquipo\":\"A Cuidar las piernas\",\"replCamiseta\":\"3,3,66ff,ffcc33,\",\"idLocalidad\":334325,\"replCountMeSiguen\":3},\"fecha\":\"Mar 18, 2016 3:10:51 PM\",\"fechaMillis\":1458324651449,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Malcorra, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5118964,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:21:34 PM\",\"fechaMillis\":1458328894485,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Crivelli, Federico.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5154081,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:22:20 PM\",\"fechaMillis\":1458328940457,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Olave, Juan Carlos.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155151,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:23:18 PM\",\"fechaMillis\":1458328998095,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a G\\u0026oacute;mez, Jos\\u0026eacute; Luis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155184,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:23:50 PM\",\"fechaMillis\":1458329030451,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bogino, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155857,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:25:03 PM\",\"fechaMillis\":1458329103636,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Soto, Alexis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5155884,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:27:10 PM\",\"fechaMillis\":1458329230354,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Romat, Nicol\\u0026aacute;s.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5156837,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:28:23 PM\",\"fechaMillis\":1458329303035,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Cavallaro, Juan I..\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5158221,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:28:55 PM\",\"fechaMillis\":1458329335626,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5158238,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:29:16 PM\",\"fechaMillis\":1458329356781,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Garc\\u0026iacute;a, Santiago.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159101,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:30:57 PM\",\"fechaMillis\":1458329457355,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Lo Celso, Giovani.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159908,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:31:34 PM\",\"fechaMillis\":1458329494426,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Abila, Ram\\u0026oacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5159928,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:41:55 PM\",\"fechaMillis\":1458330115339,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Rigoni, Emiliano.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5165292,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:42:33 PM\",\"fechaMillis\":1458330153243,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Buffarini, Julio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5166462,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:44:10 PM\",\"fechaMillis\":1458330250263,\"idTipo\":3,\"mensaje\":\"{user} modificó su capitán\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/miEquipo.htm\"},\"id\":5167358,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:46:20 PM\",\"fechaMillis\":1458330380060,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bou, Walter.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5168651,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 4:48:19 PM\",\"fechaMillis\":1458330499796,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Ruben, Marco.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5168698,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:48:13 PM\",\"fechaMillis\":1458334093561,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Cavallaro, Juan I..\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204239,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:48:39 PM\",\"fechaMillis\":1458334119465,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Adv\\u0026iacute;ncula, Luis.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204568,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:49:06 PM\",\"fechaMillis\":1458334146833,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Sand, Jos\\u0026eacute;.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5204594,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:49:24 PM\",\"fechaMillis\":1458334164196,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Malcorra, Ignacio.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5205309,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:54:38 PM\",\"fechaMillis\":1458334478943,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5208129,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 5:56:54 PM\",\"fechaMillis\":1458334614652,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Schunke, Jonatan.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5209817,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:03:20 PM\",\"fechaMillis\":1458335000536,\"idTipo\":3,\"mensaje\":\"{user} modificó su capitán\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/miEquipo.htm\"},\"id\":5213586,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":732886,\"visible\":true,\"ultimaLectura\":\"Feb 20, 2016 10:55:16 AM\",\"replNombreApellido\":\"manuel matias zubieta\",\"replNombreEquipo\":\"duro de Vencer F.C\",\"replCamiseta\":\"3,2,ff,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:04:09 PM\",\"fechaMillis\":1458335049013,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Torrico, Sebasti\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5214282,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:38:51 PM\",\"fechaMillis\":1458337131063,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Rodr\\u0026iacute;guez, Maxi .\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5237049,\"cssClass\":\"cambios\"},{\"usuario\":{\"id\":730876,\"visible\":true,\"ultimaLectura\":\"Feb 19, 2016 8:00:00 PM\",\"replNombreApellido\":\"Paulo Muchutti\",\"replNombreEquipo\":\"Wano FC\",\"replCamiseta\":\"2,27,ff0000,0,4\",\"idLocalidad\":319174,\"replCountMeSiguen\":2},\"fecha\":\"Mar 18, 2016 6:47:17 PM\",\"fechaMillis\":1458337637195,\"idTipo\":1,\"mensaje\":\"{user} hizo transferencias en su equipo esta fecha. Sacó a Bordagaray, Fabi\\u0026aacute;n.\",\"elink\":{\"idLinkeable\":1,\"link\":\"../grandt/transferencias.html\"},\"id\":5243327,\"cssClass\":\"cambios\"}],\"user\":{\"replCountMeSiguen\":3,\"ultimaLectura\":\"Mar 21, 2016 12:35:44 PM\",\"id\":551978,\"replCamiseta\":\"2,2,33,ff00cc,4\",\"visible\":true,\"replNombreApellido\":\"juan marcos portillo\",\"replCountSigo\":3,\"replNombreEquipo\":\"estupendeja team\"}}";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36";

    public static void main(String[] args) {
//        processPage();
        //            cargar();
        httpRequest();
        //        cargarGet();
//        Util.getChangesRank(Util.getChanges(Util.mapper(JSONSTRING)));
    }

    private static void processPage() throws IOException {
        System.setProperty("http.proxyHost", "proxy.corp.globant.com");
        System.setProperty("http.proxyPort", "3128");
        Document doc = Jsoup.connect(GDTURL).timeout(10 * 1000).get();
        Elements inputElement = doc.body().select("*");
        for (Element e : inputElement.select("input")) {
            if (null != e.getElementById("passInput")) {
                e.attr("value", "3569o8O2");
                System.out.print(2);
            } else if (null != e.getElementById("dniInput")) {
                e.attr("value", "35690802");
                System.out.print(2);
            }
        }

    }

    private static void cargar() throws IOException {
        System.setProperty("http.proxyHost", "proxy.corp.globant.com");
        System.setProperty("http.proxyPort", "3128");
        Map cookies = new HashMap<String, String>();
        cookies.put("__utma", "8982371.430037911.1458138733.1458138733.1458138733.1");
        cookies.put("__utmc", "8982371");
        cookies.put("__utmz", "8982371.1458138733.1.1.");
        cookies.put("cX_S", "iluy5jaq4f64qyjl");
        cookies.put("nav23111", "24841469847_216");
        cookies.put("cX_P", "iluy5jarthfj7f4e");
        cookies.put("cX_segmentInfo", "1b842017c6699ed94ff304c6b372b35e88a1ec0a_1458138734_");
        cookies.put("loginMethod", "documento");
        Document document = Jsoup.connect("http://www.grandt.clarin.com/grandt/ini.htm?idPlataforma=1")
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .header("Cache-Control", "max-age=0")
                .header("Proxy-Connection", "keep-alive")
                .header("Referer", "http://www.grandt.clarin.com/html/login.html?s=9470981458240946171")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("User-Agent", "Chrome/43.0.2357.81")
                .data("password", "3569o8O2")
                .data("nroDocumento", "35690802")
                .data("tipoDocumento", "1")
                .cookies(cookies)
                .timeout(10 * 1000)
                .post();
        Elements inputElement = document.body().select("*");

        System.out.print(true);

    }

    private static void cargarGet() throws IOException {
        System.setProperty("http.proxyHost", "proxy.corp.globant.com");
        System.setProperty("http.proxyPort", "3128");
        Map cookies = new HashMap<String, String>();
        cookies.put("__utma", "8982371.430037911.1458138733.1458138733.1458138733.1");
        cookies.put("__utmc", "8982371");
        cookies.put("__utmz", "8982371.1458138733.1.1.");
        cookies.put("cX_S", "iluy5jaq4f64qyjl");
        cookies.put("nav23111", "24841469847_216");
        cookies.put("cX_P", "iluy5jarthfj7f4e");
        cookies.put("cX_segmentInfo", "1b842017c6699ed94ff304c6b372b35e88a1ec0a_1458138734_");
        cookies.put("loginMethod", "documento");
        cookies.put("JSESSIONID", "3E7FDB0974CC9552F09E1A16C4DC204B.n19");

        Connection con = Jsoup.connect("http://www.grandt.clarin.com/grandt/timeline.htm?_action=init&_r=4010361458240683848&csrf=354737")
//        Connection con = Jsoup.connect("http://www.grandt.clarin.com/grandt/timeline.htm?csrf=599348")
                .header("Proxy-Connection", "keep-alive")
                .header("host", "www.grandt.clarin.com")

//                .header("Referer", "http://www.grandt.clarin.com/grandt/ini.htm?inpath=../html/seguirUsuario/seguirUsuario.html")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36")
                .method(Connection.Method.GET);

        Document document = con.get();

        Elements inputElement = document.body().select("*");

        System.out.print(true);

    }

    public static void httpRequest() {
        System.setProperty("http.proxyHost", "proxy.corp.globant.com");
        System.setProperty("http.proxyPort", "3128");
        try {
            URLConnection connection = new URL("https://www.google.com.ar/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=sda").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
//
//            URL url = new URL("http://www.grandt.clarin.com/grandt/timeline.htm?_action=init&_r=4010361458240683848&csrf=452374");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("User-Agent", USER_AGENT);
//            connection.setRequestProperty("Accept", "*/*");
//            connection.setRequestProperty("Proxy-Connection", "keep-alive");
//            connection.setRequestProperty("host", "www.grandt.clarin.com");
//            connection.connect();
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.print(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

