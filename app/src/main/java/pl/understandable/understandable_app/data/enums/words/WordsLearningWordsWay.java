package pl.understandable.understandable_app.data.enums.words;

import pl.understandable.understandable_app.R;
import pl.understandable.understandable_app.data.enums.Identifiable;

/**
 * Created by Marcin Zielonka on 2018-02-28.
 */

public enum WordsLearningWordsWay implements Identifiable {

    ALL_WORDS("wszystkie słówka", R.drawable.f_words_choice_way_all_words),
    NOT_LEARNED("nienauczone słówka", R.drawable.f_words_choice_way_not_learned_words);

    private String name;
    private int resId;

    private WordsLearningWordsWay(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getResId() {
        return resId;
    }

}
