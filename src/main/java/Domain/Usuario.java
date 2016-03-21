package Domain;

public class Usuario {
    private String replCountMeSiguen;

    private String ultimaLectura;

    private String id;

    private String replCamiseta;

    private String visible;

    private String replNombreApellido;

    private String idLocalidad;

    private String replNombreEquipo;

    public String getReplCountMeSiguen ()
    {
        return replCountMeSiguen;
    }

    public void setReplCountMeSiguen (String replCountMeSiguen)
    {
        this.replCountMeSiguen = replCountMeSiguen;
    }

    public String getUltimaLectura ()
    {
        return ultimaLectura;
    }

    public void setUltimaLectura (String ultimaLectura)
    {
        this.ultimaLectura = ultimaLectura;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

    public String getIdLocalidad ()
    {
        return idLocalidad;
    }

    public void setIdLocalidad (String idLocalidad)
    {
        this.idLocalidad = idLocalidad;
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
        return "ClassPojo [replCountMeSiguen = "+replCountMeSiguen+", ultimaLectura = "+ultimaLectura+", id = "+id+", replCamiseta = "+replCamiseta+", visible = "+visible+", replNombreApellido = "+replNombreApellido+", idLocalidad = "+idLocalidad+", replNombreEquipo = "+replNombreEquipo+"]";
    }
}