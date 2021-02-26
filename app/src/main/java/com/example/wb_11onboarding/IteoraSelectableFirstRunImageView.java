package com.example.wb_11onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IteoraSelectableFirstRunImageView extends IteoraAbstractFirstRunView {

    private ImageView ivImage;
    private TextView tvText;

    private int activeBackgroundRes;
    private int inActiveBackgroundRes;

    public IteoraSelectableFirstRunImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.iteora_selectable_first_run_image_view;
    }

    @Override
    protected void onPostInit(View rootView, @Nullable AttributeSet attrs) {
        this.ivImage = rootView.findViewById(R.id.iv_image);
        this.tvText = rootView.findViewById(R.id.tv_item_title);

        this.activeBackgroundRes = R.drawable.onboarding_support_item_active;
        this.inActiveBackgroundRes = R.drawable.onboarding_support_item_inactive;

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layoutParams.topMargin = 30;
        setLayoutParams(layoutParams);

        if (attrs != null) {
            final TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.IteoraSelectableFirstRunImageView, 0, 0);

            try {

                final int imageDrawableResId = ta.getResourceId(R.styleable.IteoraSelectableFirstRunImageView_android_src, 0);

                if (imageDrawableResId != 0) {
                    ivImage.setImageDrawable(ContextCompat.getDrawable(getContext(), imageDrawableResId));
                }

                final int textResId = ta.getResourceId(R.styleable.IteoraSelectableFirstRunImageView_android_text, 0);
                if (textResId != 0) {
                    tvText.setText(textResId);
                }

            } finally {
                ta.recycle();
            }
        }
    }

    void setImage(final int imageRes) {
        ivImage.setImageDrawable(ContextCompat.getDrawable(getContext(), imageRes));
    }

    TextView getText() {
        return tvText;
    }

    void onViewSelected() {
        setBackground(ContextCompat.getDrawable(getContext(), activeBackgroundRes));
        tvText.setTextColor(Color.parseColor("#0080ff"));
    }

    void onViewDeselected() {
        setBackground(ContextCompat.getDrawable(getContext(), inActiveBackgroundRes));
        tvText.setTextColor(Color.parseColor("#363d47"));
    }
}
