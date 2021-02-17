package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class IteoraFirstRunControllerSimple extends IteoraAbstractFirstRunView {

    private Button btnAction;

    public IteoraFirstRunControllerSimple(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_first_run_controller_simple;
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        setGravity(Gravity.BOTTOM);

        this.btnAction = (Button) rootView.findViewById(R.id.btn_action);

        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunControllerSimple, 0, 0);

            try {
                final int actionButtonTextResId = ta.getResourceId(R.styleable.IteoraFirstRunControllerSimple_simpleActionButtonText, 0);

                if (actionButtonTextResId != 0) {
                    btnAction.setText(actionButtonTextResId);
                }
            } finally {
                ta.recycle();
            }
        }
    }

    public int getActionButtonId() {
        return btnAction.getId();
    }
}
