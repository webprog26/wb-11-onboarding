package com.example.wb_11onboarding;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class IteoraOnBoardingDefaultBrowserFragment extends IteoraAbstractOnBoardingFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_default_browser_fragment;
    }

    @Override
    protected int getViewNextId() {
        return R.id.btn_skip;
    }

    @Override
    protected int getViewPrimaryActionId() {
        return R.id.btn_agree;
    }

    @Override
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_SET_AS_DEFAULT_BROWSER;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        ((TextView) view.findViewById(R.id.tv_set_as_default_title)).setText(Html.fromHtml(getString(R.string.onboarding_set_as_default_title)));
    }
}
