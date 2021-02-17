package com.example.wb_11onboarding;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class IteoraOnBoardingSupportFragment extends IteoraAbstractOnBoardingFragment {

    private IteoraFirstRunSelectableView firstRunSelectableView;

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_support_fragment;
    }

    @Override
    protected int getViewNextId() {
        return R.id.btn_finish;
    }

    @Override
    protected int getViewPrimaryActionId() {
        return firstRunSelectableView.getPrimaryActionId();
    }

    @Override
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SUPPORT_WILD_ANIMALS;
    }

    @Override
    protected int getViewSecondaryActionId() {
        return firstRunSelectableView.getSecondaryActionId();
    }

    @Override
    protected int getSecondaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SUPPORT_OCEAN_LIFE;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        ((TextView) view.findViewById(R.id.tv_support_title)).setText(Html.fromHtml(getString(R.string.onboarding_support_title)));
        this.firstRunSelectableView = (IteoraFirstRunSelectableView) view.findViewById(R.id.iteora_first_run_selectable_view);
    }

    @Override
    protected int getViewActiveBackground() {
        return R.drawable.onboarding_support_item_active;
    }

    @Override
    protected int getViewInactiveBackground() {
        return R.drawable.onboarding_support_item_inactive;
    }


}
