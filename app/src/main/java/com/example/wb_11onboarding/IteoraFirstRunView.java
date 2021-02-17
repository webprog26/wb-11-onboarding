package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IteoraFirstRunView extends LinearLayout {

    private TextView tvTitle;
    private TextView tvText;

    private ImageView ivImage;

    public IteoraFirstRunView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(final Context context, @Nullable final AttributeSet attrs) {
        setOrientation(VERTICAL);

        final View rootView = LayoutInflater.from(context).inflate(R.layout.iteora_first_run_view, this, true);

        this.tvTitle = rootView.findViewById(R.id.tv_title);
        this.tvText = rootView.findViewById(R.id.tv_text);
        this.ivImage = rootView.findViewById(R.id.iv_image);

        if (attrs != null) {
            final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunView, 0, 0);

            try {
                final int titleResId = ta.getResourceId(R.styleable.IteoraFirstRunView_title, 0);

                if (titleResId != 0) {
                    tvTitle.setText(titleResId);
                }

                final int textResId = ta.getResourceId(R.styleable.IteoraFirstRunView_android_text, 0);

                if (textResId != 0) {
                    tvText.setText(textResId);
                }

                final int imageDrawableResId = ta.getResourceId(R.styleable.IteoraFirstRunView_android_src, 0);

                if (imageDrawableResId != 0) {
                    ivImage.setImageDrawable(ContextCompat.getDrawable(context, imageDrawableResId));
                }

            } finally {
                ta.recycle();
            }
        }
    }

    public void setTitle(final CharSequence title) {
        tvTitle.setText(title);
    }

    public void setText(final CharSequence text) {
        tvText.setText(text);
    }
}
