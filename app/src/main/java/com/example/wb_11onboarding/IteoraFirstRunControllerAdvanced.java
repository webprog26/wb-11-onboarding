package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class IteoraFirstRunControllerAdvanced extends IteoraAbstractFirstRunView {

    private Button btnAction;
    private Button btnSkip;

    public IteoraFirstRunControllerAdvanced(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_first_run_controler_advanced;
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        setGravity(Gravity.BOTTOM);

        this.btnAction = (Button) rootView.findViewById(R.id.btn_action);
        this.btnSkip = (Button) rootView.findViewById(R.id.btn_skip);

        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunControllerAdvanced, 0, 0);

            try {
                final int actionButtonTextResId = ta.getResourceId(R.styleable.IteoraFirstRunControllerAdvanced_advancedActionButtonText, 0);

                if (actionButtonTextResId != 0) {
                    btnAction.setText(actionButtonTextResId);
                }

                final int skipButtonTextResId = ta.getResourceId(R.styleable.IteoraFirstRunControllerAdvanced_skipButtonText, 0);

                if (skipButtonTextResId != 0) {
                    btnSkip.setText(skipButtonTextResId);
                }

            } finally {
                ta.recycle();
            }
        }
    }

    public int getActionButtonId() {
        return btnAction.getId();
    }

    public int getSkipButtonId() {
        return btnSkip.getId();
    }

    public void setSkipButtonText(final CharSequence text) {
        btnSkip.setText(text);
    }
}
