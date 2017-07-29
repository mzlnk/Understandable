package pl.understandable.understandable_app.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import pl.understandable.understandable_app.activities.NavigationActivity;

import java.util.List;

/**
 * Created by Marcin on 2017-07-07.
 */

public class FragmentUtil {

    public static final String F_WORDS_CHOICE_CATEGORY = "f_words_choice_category";
    public static final String F_WORDS_CHOICE_LENGTH = "f_words_choice_length";
    public static final String F_WORDS_CHOICE_MODE = "f_words_choice_mode";
    public static final String F_WORDS_CHOICE_TYPE = "f_words_choice_type";
    public static final String F_WORDS_CHOICE_WAY = "f_words_choice_way";
    public static final String F_NO_WORDS_ERROR = "f_no_words_error";
    public static final String F_WORDS_LIST = "f_words_list";
    public static final String F_WORDS_QUIZ = "f_words_quiz";
    public static final String F_WORDS_QUIZ_RESULT = "f_words_quiz_result";
    public static final String F_WORDS_QUIZ_RESULT_CORRECT_WORDS_SUMMARY = "f_words_quiz_result_correct_words_summary";
    public static final String F_WORDS_QUIZ_RESULT_INCORRECT_WORDS_SUMMARY = "f_words_quiz_result_incorrect_words_summary";
    public static final String F_WORDS_REPETITION = "f_words_repetition";
    public static final String F_WORDS_REPETITION_EXAMPLE = "f_words_repetition_example";
    public static final String F_WORDS_REPETITION_RESULT = "f_words_repetition_result";
    public static final String F_WORDS_REPETITION_RESULT_WORDS_TO_REPEAT = "f_words_repetition_result_words_to_repeat";
    public static final String F_IRREGULAR_VERBS_CHOICE_MODE = "f_irregular_verbs_choice_mode";
    public static final String F_IRREGULAR_VERBS_CHOICE_LENGTH = "f_irregular_verbs_choice_length";
    public static final String F_IRREGULAR_VERBS_LIST = "f_irregular_verbs_list";
    public static final String F_IRREGULAR_VERBS_REPETITION = "f_irregular_verbs_repetition";
    public static final String F_IRREGULAR_VERBS_REPETITION_EXAMPLE = "f_irregular_verbs_repetition_example";
    public static final String F_IRREGULAR_VERBS_REPETITION_RESULT = "f_irregular_verbs_repetition_result";
    public static final String F_IRREGULAR_VERBS_REPETITION_RESULT_WORDS_TO_REPEAT = "f_irregular_verbs_repetition_result_words_to_repeat";
    public static final String F_START = "f_start";
    public static final String F_THEME_CHOICE = "f_theme_choice";
    public static final String F_DOWNLOAD_CUSTOM_WORDS_SET = "f_download_custom_words_set";
    public static final String F_CUSTOM_WORDS_SETS_LIST = "f_custom_words_sets_list";
    public static final String F_CUSTOM_WORDS_SET_PREVIEW = "f_custom_words_set_preview";
    public static final String F_CUSTOM_WORDS_SET_PREVIEW_EDIT = "f_custom_words_set_preview_edit";


    public static Fragment getVisibleFragment() {
        FragmentManager fragmentManager = NavigationActivity.activity.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments != null) {
            for(Fragment fragment : fragments) {
                if(fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
        }
        return null;
    }

}