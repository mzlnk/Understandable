package pl.understandable.understandable_dev_app.utils.buttons.grammar;

import android.content.Context;

import pl.understandable.understandable_dev_app.data.enums.Identifiable;
import pl.understandable.understandable_dev_app.data.params.GrammarDataParams;
import pl.understandable.understandable_dev_app.utils.buttons.BaseButton;

/**
 * Created by Marcin Zielonka on 2017-08-12.
 */

public abstract class GrammarBaseButton extends BaseButton<GrammarDataParams> {

    public GrammarBaseButton(Context context, GrammarDataParams dataParams, Identifiable enumType, boolean checked) {
        super(context, dataParams, enumType, checked);
    }


}