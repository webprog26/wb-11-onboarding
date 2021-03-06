package com.example.wb_11onboarding;

import android.view.View;

public class IteoraOnBoardingSupportFragment extends IteoraAbstractOnBoardingFragment {

    private IteoraFirstRunViewAdvanced firstRunViewAdvanced;
    private IteoraFirstRunControllerSimple controllerSimple;

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_support_fragment;
    }

    @Override
    protected int getViewNextId() {
        return controllerSimple.getActionButtonId();
    }

    @Override
    protected int getViewPrimaryActionId() {
        return firstRunViewAdvanced.getSelectableView().getPrimaryActionId();
    }

    @Override
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SUPPORT_WILD_ANIMALS;
    }

    @Override
    protected int getViewSecondaryActionId() {
        return firstRunViewAdvanced.getSelectableView().getSecondaryActionId();
    }

    @Override
    protected int getSecondaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SUPPORT_OCEAN_LIFE;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        this.firstRunViewAdvanced = (IteoraFirstRunViewAdvanced) view.findViewById(R.id.iteora_first_run_view_advanced);
        firstRunViewAdvanced.setTitle(parseHtmlString(R.string.onboarding_support_title));

        this.controllerSimple = (IteoraFirstRunControllerSimple) view.findViewById(R.id.controls_container);
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
