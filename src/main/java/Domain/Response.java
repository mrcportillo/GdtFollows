package Domain;

/**
 * Created by juan.portillo on 21/03/16.
 */
public class Response {
    private TimeLine[] timeline;

    private User user;

    public TimeLine[] getTimeline ()
    {
        return timeline;
    }

    public void setTimeline (TimeLine[] timeline)
    {
        this.timeline = timeline;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timeline = "+timeline+", user = "+user+"]";
    }
}
