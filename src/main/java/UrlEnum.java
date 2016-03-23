/**
 * Created by juan.portillo on 23/03/16.
 */
public enum UrlEnum {
    POST_URL("/grandt/ini.htm?idPlataforma=1"),
    GET_URL("/grandt/timeline.htm?_action=init&_r=4010361458240683848&csrf="),
    BASE_URL("www.grandt.clarin.com");

    private final String text;

    UrlEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
