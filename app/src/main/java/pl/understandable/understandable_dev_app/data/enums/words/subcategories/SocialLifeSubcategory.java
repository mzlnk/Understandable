package pl.understandable.understandable_dev_app.data.enums.words.subcategories;

import pl.understandable.understandable_dev_app.R;
import pl.understandable.understandable_dev_app.data.enums.Identifiable;

/**
 * Created by Marcin Zielonka on 2017-08-24.
 */

public enum SocialLifeSubcategory implements Identifiable {

    RELATIONSHIP("stosunki"),
    FREE_TIME("czas wolny"),
    LIFESTYLE("styl życia");

    private String name;

    private SocialLifeSubcategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getResId() {
        return R.drawable.f_words_choice_unchecked;
    }

}
