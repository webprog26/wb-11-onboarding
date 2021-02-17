package com.example.wb_11onboarding;

import android.view.View;

public class IteoraOnBoardingStartFragment extends IteoraAbstractOnBoardingFragment {

    private IteoraFirstRunControllerSimple controllerSimple;

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_start_fragment;
    }


    @Override
    protected int getViewNextId() {
        return controllerSimple.getActionButtonId();
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        final IteoraFirstRunView iteoraFirstRunView = (IteoraFirstRunView) view.findViewById(R.id.iteora_first_run_view);
        iteoraFirstRunView.setTitle(parseHtmlString(R.string.onboarding_start_title));
        iteoraFirstRunView.setText(parseHtmlString(R.string.onboarding_start_text));

        this.controllerSimple = (IteoraFirstRunControllerSimple) view.findViewById(R.id.controls_container);
    }
}
