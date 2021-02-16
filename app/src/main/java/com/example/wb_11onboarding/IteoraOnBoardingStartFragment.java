package com.example.wb_11onboarding;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

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
        ((TextView) view.findViewById(R.id.tv_start_title)).setText(Html.fromHtml(getString(R.string.onboarding_start_title)));
        ((TextView) view.findViewById(R.id.tv_start_text)).setText(Html.fromHtml(getString(R.string.onboarding_start_text)));
    }
}
