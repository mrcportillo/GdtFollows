package Domain;

/**
 * Created by juan.portillo on 21/03/16.
 */
public class TimeLine {
    private String id;

    private String fecha;

    private String fechaMillis;

    private Usuario usuario;

    private Elink elink;

    private String cssClass;

    private String mensaje;

    private String idTipo;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFecha ()
    {
        return fecha;
    }

    public void setFecha (String fecha)
    {
        this.fecha = fecha;
    }

    public String getFechaMillis ()
    {
        return fechaMillis;
    }

    public void setFechaMillis (String fechaMillis)
    {
        this.fechaMillis = fechaMillis;
    }

    public Usuario getUsuario ()
    {
        return usuario;
    }

    public void setUsuario (Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Elink getElink ()
    {
        return elink;
    }

    public void setElink (Elink elink)
    {
        this.elink = elink;
    }

    public String getCssClass ()
    {
        return cssClass;
    }

    public void setCssClass (String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getMensaje ()
    {
        return mensaje;
    }

    public void setMensaje (String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getIdTipo ()
    {
        return idTipo;
    }

    public void setIdTipo (String idTipo)
    {
        this.idTipo = idTipo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", fecha = "+fecha+", fechaMillis = "+fechaMillis+", usuario = "+usuario+", elink = "+elink+", cssClass = "+cssClass+", mensaje = "+mensaje+", idTipo = "+idTipo+"]";
    }
}
