package net.heliantum.understandable.fragments.irregular_verbs.repetition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import net.heliantum.understandable.R;
import net.heliantum.understandable.data.irregular_verbs_data.IrregularVerbsRepetitionData;
import net.heliantum.understandable.data.words_data.WordsRepetitionData;
import net.heliantum.understandable.database.entity.IrregularVerbEntity;
import net.heliantum.understandable.database.entity.LanguageEntity;
import net.heliantum.understandable.database.entity.enums.IrregularVerbEnum;
import net.heliantum.understandable.utils.ColorUtil;
import net.heliantum.understandable.utils.font.Font;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class IrregularVerbsRepetitionResultWordsToRepeatFragment extends Fragment {

    private IrregularVerbsRepetitionData repetitionData = IrregularVerbsRepetitionData.getRepetitionData();

    private int list1Color, list2Color, textColor;

    private RelativeLayout mainLayout;
    private TextView title;
    private TableLayout wordsTable;
    private Button back;

    public IrregularVerbsRepetitionResultWordsToRepeatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the mainLayout for this fragment
        View rootView =  inflater.inflate(R.layout.f_irregular_verbs_repetition_result_words_to_repeat, container, false);
        initColors();
        loadViewFromXml(rootView);
        prepareLayout();
        addListeners();

        return rootView;
    }

    private void loadViewFromXml(View rootView) {
        mainLayout = (RelativeLayout) rootView.findViewById(R.id.f_irregular_verbs_repetition_result_words_to_repeat);
        title = (TextView) rootView.findViewById(R.id.f_irregular_verbs_repetition_result_words_to_repeat_title);
        wordsTable = (TableLayout) rootView.findViewById(R.id.f_irregular_verbs_repetition_result_words_to_repeat_table);
        back = (Button) rootView.findViewById(R.id.f_irregular_verbs_repetition_result_words_to_repeat_back);
    }

    private void prepareLayout() {
        setAnimation();
        setFonts();
        addWords();
    }

    private void setAnimation() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fade00);
        mainLayout.setAnimation(anim);
    }

    private void setFonts() {
        title.setTypeface(Font.TYPEFACE_MONTSERRAT);
        back.setTypeface(Font.TYPEFACE_MONTSERRAT);
    }

    private void addWords() {
        boolean color = true;

        for(IrregularVerbEntity word : repetitionData.wordsToRepeat) {
            //todo: add setSize method & values in dimens.xml
            TableRow row = new TableRow(getContext());
            TextView t1 = new TextView(getContext());
            TextView t2 = new TextView(getContext());
            TextView t3 = new TextView(getContext());
            TextView t4 = new TextView(getContext());
            prepareCell(t1, word.getPolishWord());
            prepareCell(t2, word.getEnglishWord(IrregularVerbEnum.INFINITVE));
            prepareCell(t3, word.getEnglishWord(IrregularVerbEnum.SIMPLE_PAST));
            prepareCell(t4, word.getEnglishWord(IrregularVerbEnum.PAST_PARTICIPLE));

            if(color) {
                row.setBackgroundColor(list1Color);
            } else {
                row.setBackgroundColor(list2Color);
            }
            color = !color;

            row.setMeasureWithLargestChildEnabled(true);
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);
            wordsTable.addView(row);
        }
    }

    private void prepareCell(TextView textView, String content) {
        textView.setText(content);
        textView.setTextColor(textColor);
        textView.setTypeface(Font.TYPEFACE_MONTSERRAT);
        textView.setLayoutParams(new TableRow.LayoutParams(MATCH_PARENT, MATCH_PARENT, 0.25F));
    }

    private void addListeners() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }

    private void initColors() {
        ColorUtil colorUtil = new ColorUtil(getContext());
        list1Color = colorUtil.getColor(R.attr.list_1_color);
        list2Color = colorUtil.getColor(R.attr.list_2_color);
        textColor = colorUtil.getColor(R.attr.text_1_color);
    }

}
