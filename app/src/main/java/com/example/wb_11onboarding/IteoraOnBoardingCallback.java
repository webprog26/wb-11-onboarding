package com.example.wb_11onboarding;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IteoraOnBoardingCallback {

    @IntDef({
            OnBoardingActionType.NO_ACTION_TYPE,
            OnBoardingActionType.ACTION_SET_AS_DEFAULT_BROWSER,
            OnBoardingActionType.ACTION_INVITE_FRIENDS,
            OnBoardingActionType.ACTION_SUPPORT_WILD_ANIMALS,
            OnBoardingActionType.ACTION_SUPPORT_OCEAN_LIFE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface OnBoardingActionType {

        int NO_ACTION_TYPE = -1;

        int ACTION_SET_AS_DEFAULT_BROWSER = 0;

        int ACTION_INVITE_FRIENDS = 1;

        int ACTION_SUPPORT_WILD_ANIMALS = 2;

        int ACTION_SUPPORT_OCEAN_LIFE = 4;
    }


        void onNextClicked();

        void onActionClicked(@OnBoardingActionType final int actionType);
}
