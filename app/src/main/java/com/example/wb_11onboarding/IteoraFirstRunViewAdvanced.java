package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class IteoraFirstRunViewAdvanced extends IteoraAbstractFirstRunView {

    private TextView tvTitle;
    private TextView tvText;

    private IteoraFirstRunSelectableView selectableView;

    public IteoraFirstRunViewAdvanced(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_first_run_view_advanced;
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        this.tvTitle = rootView.findViewById(R.id.tv_title);
        this.tvText = rootView.findViewById(R.id.tv_text);

        this.selectableView = (IteoraFirstRunSelectableView) rootView.findViewById(R.id.iteora_first_run_selectable_view);

        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunViewAdvanced, 0, 0);

            try {
                final int titleResId = ta.getResourceId(R.styleable.IteoraFirstRunViewAdvanced_firstRunViewTitleAdvanced, 0);

                if (titleResId != 0) {
                    tvTitle.setText(titleResId);
                }

                final int textResId = ta.getResourceId(R.styleable.IteoraFirstRunViewAdvanced_android_text, 0);

                if (textResId != 0) {
                    tvText.setText(textResId);
                }

            } finally {
                ta.recycle();
            }
        }
    }

    public IteoraFirstRunSelectableView getSelectableView() {
        return selectableView;
    }

    public void setTitle(final CharSequence title) {
        tvTitle.setText(title);
    }

    public void setText(final CharSequence text) {
        tvText.setText(text);
    }
}
