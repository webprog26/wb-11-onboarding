package com.example.wb_11onboarding;

import android.view.View;

public class IteoraOnBoardingDefaultBrowserFragment extends IteoraAbstractOnBoardingFragment {

    private IteoraFirstRunControllerAdvanced controllerAdvanced;

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_default_browser_fragment;
    }

    @Override
    protected int getViewNextId() {
        return controllerAdvanced.getSkipButtonId();
    }

    @Override
    protected int getViewPrimaryActionId() {
        return controllerAdvanced.getActionButtonId();
    }

    @Override
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SET_AS_DEFAULT_BROWSER;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        ((IteoraFirstRunView) view.findViewById(R.id.iteora_first_run_view)).setTitle(parseHtmlString(R.string.onboarding_set_as_default_title));

        this.controllerAdvanced = (IteoraFirstRunControllerAdvanced) view.findViewById(R.id.controls_container);
    }
}
