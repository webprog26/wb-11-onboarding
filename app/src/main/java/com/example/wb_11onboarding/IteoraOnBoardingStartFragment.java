package com.example.wb_11onboarding;

import android.text.Html;
import android.view.View;

public class IteoraOnBoardingStartFragment extends IteoraAbstractOnBoardingFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_start_fragment;
    }


    @Override
    protected int getViewNextId() {
        return R.id.btn_start;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        final IteoraFirstRunView iteoraFirstRunView = (IteoraFirstRunView) view.findViewById(R.id.iteora_first_run_view);
        iteoraFirstRunView.setTitle(Html.fromHtml(getString(R.string.onboarding_start_title)));
        iteoraFirstRunView.setText(Html.fromHtml(getString(R.string.onboarding_start_text)));
    }
}
