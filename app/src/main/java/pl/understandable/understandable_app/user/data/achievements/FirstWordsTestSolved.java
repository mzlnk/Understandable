package pl.understandable.understandable_app.user.data.achievements;

import pl.understandable.understandable_app.R;

/**
 * Created by Marcin Zielonka on 2017-11-25.
 */

public class FirstWordsTestSolved extends Achievement {

    @Override
    public AchievementId getId() {
        return AchievementId.FIRST_WORDS_TEST_SOLVED;
    }

    @Override
    public String getName() {
        return "Pierwsze słowo";
    }

    @Override
    public String getDescription() {
        return "Pierwszy rozwiązany test ze słówek";
    }

    @Override
    public boolean isAchievable() {
        return false;
    }

    @Override
    public int getResId() {
        return R.drawable.f_user_achievements_ftswords;
    }

}
