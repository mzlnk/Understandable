package pl.understandable.understandable_dev_app.user.data.achievements;

import java.util.Calendar;

/**
 * Created by Marcin Zielonka on 2017-11-25.
 */

public class LearningInTheMorning extends Achievement {

    @Override
    public boolean isAchievable() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour >= 6 && hour <= 9;
    }

}
