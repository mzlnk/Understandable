package pl.understandable.understandable_app.user.requests;

import pl.understandable.understandable_app.user.Request;
import pl.understandable.understandable_app.user.SyncManager;
import pl.understandable.understandable_app.user.UserManager;

/**
 * Created by Marcin Zielonka on 2017-12-09.
 */

public class ChangeUserName implements Request {

    private String name;

    public ChangeUserName(String name) {
        this.name = name;
    }

    @Override
    public void executeRequest() {
        if(UserManager.isUserSignedIn() && SyncManager.isSyncOnline()) {
            UserManager.getUser().setName(name);
            UserManager.setSyncRequired(true);
            UserManager.addElementToSync(UserManager.SyncElement.GENERAL);
        }
    }

}
