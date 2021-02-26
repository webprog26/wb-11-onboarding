package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IteoraFirstRunView extends IteoraAbstractFirstRunView {

    private TextView tvTitle;
    private TextView tvText;

    public IteoraFirstRunView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        this.tvTitle = rootView.findViewById(R.id.tv_title);
        this.tvText = rootView.findViewById(R.id.tv_text);
        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunView, 0, 0);

            try {
                final int titleResId = ta.getResourceId(R.styleable.IteoraFirstRunView_firstRunViewTitle, 0);

                if (titleResId != 0) {
                    tvTitle.setText(titleResId);
                }

                final int textResId = ta.getResourceId(R.styleable.IteoraFirstRunView_android_text, 0);

                if (textResId != 0) {
                    tvText.setText(textResId);
                }

                final int imageDrawableResId = ta.getResourceId(R.styleable.IteoraFirstRunView_android_src, 0);

                if (imageDrawableResId != 0) {
                    ((ImageView) rootView.findViewById(R.id.iv_image)).setImageDrawable(ContextCompat.getDrawable(getContext(), imageDrawableResId));
                }

            } finally {
                ta.recycle();
            }
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_first_run_view;
    }

    public void setTitle(final CharSequence title) {
        tvTitle.setText(title);
    }

    public void setText(final CharSequence text) {
        tvText.setText(text);
    }
}
