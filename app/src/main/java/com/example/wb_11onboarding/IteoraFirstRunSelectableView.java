package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

public class IteoraFirstRunSelectableView extends IteoraAbstractFirstRunView {

    private IteoraSelectableFirstRunImageView primarySelectableImageView;
    private IteoraSelectableFirstRunImageView secondarySelectableImageView;

    public IteoraFirstRunSelectableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        this.primarySelectableImageView = (IteoraSelectableFirstRunImageView) rootView.findViewById(R.id.primary_selectable_image_view);
        this.secondarySelectableImageView = (IteoraSelectableFirstRunImageView) rootView.findViewById(R.id.secondary_selectable_image_view);

        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraFirstRunSelectableView, 0, 0);

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

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_first_run_selectable_view;
    }

    int getPrimaryActionId() {
        return primarySelectableImageView.getId();
    }

    int getSecondaryActionId() {
        return secondarySelectableImageView.getId();
    }

    void onViewSelected(int id) {
        if (id == primarySelectableImageView.getId()) {
            primarySelectableImageView.onViewSelected();
        } else {
            secondarySelectableImageView.onViewSelected();
        }

    }

    void onViewDeselected(int id) {
        if (id == primarySelectableImageView.getId()) {
            primarySelectableImageView.onViewDeselected();
        } else {
            secondarySelectableImageView.onViewDeselected();
        }
    }
}
