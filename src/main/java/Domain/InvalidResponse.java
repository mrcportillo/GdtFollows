package Domain;

/**
 * Created by juan.portillo on 22/03/16.
 */
public class InvalidResponse {
    private Error error;

    private String remCSRF;

    public Error getError ()
    {
        return error;
    }

    public void setError (Error error)
    {
        this.error = error;
    }

    public String getRemCSRF ()
    {
        return remCSRF;
    }

    public void setRemCSRF (String remCSRF)
    {
        this.remCSRF = remCSRF;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [error = "+error+", remCSRF = "+remCSRF+"]";
    }
}
