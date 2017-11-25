package pl.understandable.understandable_dev_app.user;

/**
 * Created by Marcin Zielonka on 2017-10-13.
 */

public interface Request {

    public RequestType getRequestType();
    public void executeRequest();

    public static enum RequestType {
        STATS,
        ACHIEVEMENTS;
    }

}
