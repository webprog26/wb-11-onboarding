package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class IteoraFirstRunSelectableView extends LinearLayout {

    private IteoraSelectableFirstRunImageView primarySelectableImageView;
    private IteoraSelectableFirstRunImageView secondarySelectableImageView;

    public IteoraFirstRunSelectableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(final Context context, @Nullable final AttributeSet attrs) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        final View rootView = LayoutInflater.from(context).inflate(R.layout.iteora_first_run_selectable_view, this, true);
        this.primarySelectableImageView = (IteoraSelectableFirstRunImageView) rootView.findViewById(R.id.primary_selectable_image_view);
        this.secondarySelectableImageView = (IteoraSelectableFirstRunImageView) rootView.findViewById(R.id.secondary_selectable_image_view);

        if (attrs != null) {
            final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunSelectableView, 0, 0);

            try {
                final int primaryImageResId = ta.getResourceId(R.styleable.IteoraFirstRunSelectableView_primaryImageSrc, 0);

                if (primaryImageResId != 0) {
                    primarySelectableImageView.setImage(primaryImageResId);
                }

                final int secondaryImageResId = ta.getResourceId(R.styleable.IteoraFirstRunSelectableView_secondaryImageSrc, 0);

                if (secondaryImageResId != 0) {
                    secondarySelectableImageView.setImage(secondaryImageResId);
                }
            } finally {
                ta.recycle();
            }
        }
    }

    int getPrimaryActionId() {
        return primarySelectableImageView.getId();
    }

    int getSecondaryActionId() {
        return secondarySelectableImageView.getId();
    }
}
