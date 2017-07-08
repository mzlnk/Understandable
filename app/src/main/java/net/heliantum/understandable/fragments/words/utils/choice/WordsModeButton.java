package net.heliantum.understandable.fragments.words.utils.choice;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import net.heliantum.understandable.R;
import net.heliantum.understandable.data.params.WordsDataParams;
import net.heliantum.understandable.data.enums.words.WordsLearningMode;

import java.util.List;

/**
 * Created by Marcin on 2017-05-07.
 */

public class WordsModeButton extends WordsBaseButton {

    private List<WordsModeButton> allModes;
    private WordsLearningMode mode;

    public WordsModeButton(Context context, WordsDataParams dataParams, WordsLearningMode mode, List<WordsModeButton> allModes) {
        super(context, dataParams, mode);
        this.mode = mode;
        this.allModes = allModes;
        prepare();
        setSize();
        setImage();
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getText() {
        return text;
    }

    private WordsLearningMode getMode() {
        return mode;
    }

    @Override
    protected void setChoiceState() {
        if(dataParams.isChosen(mode)) {
            image.setImageAlpha(ITEM_CHOSEN);
        } else {
            image.setImageAlpha(ITEM_NOT_CHOSEN);
        }
    }

    @Override
    protected void setOnClickListener() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(image.getImageAlpha() == ITEM_NOT_CHOSEN) {
                    image.setImageAlpha(ITEM_CHOSEN);
                    dataParams.setMode(mode);
                    for(WordsModeButton m : allModes) {
                        if(m.getMode().equals(mode)) {
                            continue;
                        }
                        m.getImage().setImageAlpha(ITEM_NOT_CHOSEN);
                    }
                }
            }
        });
    }

    private void setSize() {
        int imageSize = (int) super.context.getResources().getDimension(R.dimen.f_words_choice_mode_icon_size);
        int textSize = (int) super.context.getResources().getDimension(R.dimen.f_words_choice_mode_icon_text);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(imageSize, imageSize);
        super.image.setLayoutParams(layoutParams);
        super.text.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    private void setImage() {
        super.image.setImageResource(mode.getResId());
    }

}