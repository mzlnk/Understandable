package net.heliantum.understandable.data.enums.words;

import net.heliantum.understandable.R;
import net.heliantum.understandable.data.enums.Identifiable;

/**
 * Created by Marcin Zielonka on 2016-11-11.
 */

public enum WordsLanguageCategory implements Identifiable {

    HUMAN("człowiek", R.drawable.f_words_choice_category_human),
    HOUSE("dom", R.drawable.f_words_choice_category_house),
    SCHOOL("szkoła", R.drawable.f_words_choice_category_school),
    WORK("praca", R.drawable.f_words_choice_category_work),
    FAMILY("życie rodzinne", R.drawable.f_words_choice_category_family),
    SOCIAL_LIFE("życie towarzyskie", R.drawable.f_words_choice_category_social_life),
    FOOD("jedzenie", R.drawable.f_words_choice_category_food),
    SHOPPING("zakupy", R.drawable.f_words_choice_category_shopping),
    TRAVELLING("podróżowanie", R.drawable.f_words_choice_category_travelling),
    CULTURE("kultura", R.drawable.f_words_choice_category_culture),
    HEALTH("zdrowie", R.drawable.f_words_choice_category_health),
    SPORT("sport", R.drawable.f_words_choice_category_sport),
    SCIENCE("nauka", R.drawable.f_words_choice_category_science),
    ENVIRONMENT("środowisko", R.drawable.f_words_choice_category_environment),
    SOCIETY("społeczeństwo", R.drawable.f_words_choice_category_society),
    NATION("kraj", R.drawable.f_words_choice_category_nation),
    OTHER("inne", R.drawable.f_words_choice_other);

    private String name;
    private int resId;

    private WordsLanguageCategory(String name, int resId) {
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

    public static WordsLanguageCategory getEnum(String name) {
        WordsLanguageCategory result;

        try {
            result = WordsLanguageCategory.valueOf(name);
        }catch (IllegalArgumentException e) {
            result = WordsLanguageCategory.OTHER;
        }

        return result;
    }

}