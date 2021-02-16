package com.example.wb_11onboarding;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class IteoraOnBoardingInviteFragment extends IteoraAbstractOnBoardingFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.onboarding_invite_fragment;
    }

    @Override
    protected int getViewNextId() {
        return R.id.btn_skip;
    }

    @Override
    protected int getViewPrimaryActionId() {
        return R.id.btn_action;
    }

    @Override
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.ACTION_INVITE_FRIENDS;
    }

    @Override
    protected void onViewCreatedInternal(View view) {
        ((TextView) view.findViewById(R.id.tv_invite_title)).setText(Html.fromHtml(getString(R.string.onboarding_invite_title)));
    }
}
