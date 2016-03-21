package Domain;

/**
 * Created by juan.portillo on 21/03/16.
 */
public class Elink
{
    private String link;

    private String idLinkeable;

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getIdLinkeable ()
    {
        return idLinkeable;
    }

    public void setIdLinkeable (String idLinkeable)
    {
        this.idLinkeable = idLinkeable;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [link = "+link+", idLinkeable = "+idLinkeable+"]";
    }
}
