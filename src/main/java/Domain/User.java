package Domain;

/**
 * Created by juan.portillo on 21/03/16.
 */
public class User {
    private String id;

    private String ultimaLectura;

    private String replCountMeSiguen;

    private String replCamiseta;

    private String visible;

    private String replNombreApellido;

    private String replCountSigo;

    private String replNombreEquipo;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUltimaLectura ()
    {
        return ultimaLectura;
    }

    public void setUltimaLectura (String ultimaLectura)
    {
        this.ultimaLectura = ultimaLectura;
    }

    public String getReplCountMeSiguen ()
    {
        return replCountMeSiguen;
    }

    public void setReplCountMeSiguen (String replCountMeSiguen)
    {
        this.replCountMeSiguen = replCountMeSiguen;
    }

    public String getReplCamiseta ()
    {
        return replCamiseta;
    }

    public void setReplCamiseta (String replCamiseta)
    {
        this.replCamiseta = replCamiseta;
    }

    public String getVisible ()
    {
        return visible;
    }

    public void setVisible (String visible)
    {
        this.visible = visible;
    }

    public String getReplNombreApellido ()
    {
        return replNombreApellido;
    }

    public void setReplNombreApellido (String replNombreApellido)
    {
        this.replNombreApellido = replNombreApellido;
    }

    public String getReplCountSigo ()
    {
        return replCountSigo;
    }

    public void setReplCountSigo (String replCountSigo)
    {
        this.replCountSigo = replCountSigo;
    }

    public String getReplNombreEquipo ()
    {
        return replNombreEquipo;
    }

    public void setReplNombreEquipo (String replNombreEquipo)
    {
        this.replNombreEquipo = replNombreEquipo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", ultimaLectura = "+ultimaLectura+", replCountMeSiguen = "+replCountMeSiguen+", replCamiseta = "+replCamiseta+", visible = "+visible+", replNombreApellido = "+replNombreApellido+", replCountSigo = "+replCountSigo+", replNombreEquipo = "+replNombreEquipo+"]";
    }
}
