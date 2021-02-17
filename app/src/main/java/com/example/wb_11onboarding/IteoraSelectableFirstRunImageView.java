package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class IteoraSelectableFirstRunImageView extends FrameLayout {

    private ImageView ivImage;

    public IteoraSelectableFirstRunImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        final int PADDING = 60;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layoutParams.topMargin = 30;
        setLayoutParams(layoutParams);
        setPadding(PADDING, PADDING, PADDING, PADDING);
        final View rootView = LayoutInflater.from(context).inflate(R.layout.iteora_selectable_first_run_image_view, this, true);
        this.ivImage = rootView.findViewById(R.id.iv_image);

        if (attrs != null) {
            final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IteoraSelectableFirstRunImageView, 0, 0);

            try {

                final int imageDrawableResId =  ta.getResourceId(R.styleable.IteoraSelectableFirstRunImageView_android_src, 0);

                if (imageDrawableResId != 0) {
                    ivImage.setImageDrawable(ContextCompat.getDrawable(context, imageDrawableResId));
                }

            } finally {
                ta.recycle();
            }
        }
    }
}
