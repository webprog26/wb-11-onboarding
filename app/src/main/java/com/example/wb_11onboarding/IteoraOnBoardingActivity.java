package com.example.wb_11onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IteoraOnBoardingActivity extends AppCompatActivity implements IteoraOnBoardingCallback {

    final List<IteoraAbstractOnBoardingFragment> slides = new ArrayList<>();

    private ViewPager pager;
    private int currentPagerPosition;
    private TextView tvPagesNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteora_onboarding);

        this.tvPagesNumber = (TextView) findViewById(R.id.tv_pages_count);

        slides.add(new IteoraOnBoardingStartFragment());
        slides.add(new IteoraOnBoardingDefaultBrowserFragment());
        slides.add(new IteoraOnBoardingInviteFragment());
        slides.add(new IteoraOnBoardingSupportFragment());

        this.pager = (ViewPager) findViewById(R.id.pager);
        final OnboardingPagerAdapter pagerAdapter = new OnboardingPagerAdapter(getSupportFragmentManager(), slides);
        pager.setAdapter(pagerAdapter);
        updatePagesNumber((currentPagerPosition + 1), slides.size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void updatePagesNumber(final int currentSlideNumber, final int totalSlidesNumber) {
        tvPagesNumber.setText(getString(R.string.onboarding_pages_number_text, currentSlideNumber, totalSlidesNumber));
    }

    private static class OnboardingPagerAdapter extends FragmentPagerAdapter {

        private final List<IteoraAbstractOnBoardingFragment> slides;

        public OnboardingPagerAdapter(FragmentManager fm, List<IteoraAbstractOnBoardingFragment> slides) {
            super(fm);
            this.slides = slides;
        }

        @Override
        public Fragment getItem(int position) {
            return slides.get(position);
        }

        @Override
        public int getCount() {
            return slides.size();
        }
    }

    @Override
    public void onNextClicked() {
        final int slidesNumber = (slides.size() - 1);
        Log.i("it_onb", "slidesNumber: " + slidesNumber);
        if (currentPagerPosition < slidesNumber) {
            pager.setCurrentItem(currentPagerPosition + 1);
            currentPagerPosition++;
            updatePagesNumber((currentPagerPosition + 1), slides.size());
            Log.i("it_onb", "currentPagerPosition: " + currentPagerPosition);
        } else {
            Log.i("it_onb", "onboarding finished");
            finish();
        }

    }

    @Override
    public void onActionClicked(int actionType) {
        Log.i("it_onb", "onActionClicked");
        if (OnBoardingActionType.ACTION_SET_AS_DEFAULT_BROWSER == actionType) {
            Log.i("it_onb", "ACTION_SET_AS_DEFAULT_BROWSER");
        } else if (OnBoardingActionType.ACTION_INVITE_FRIENDS == actionType) {
            Log.i("it_onb", "ACTION_INVITE_FRIENDS");
        } else if (OnBoardingActionType.ACTION_SUPPORT_WILD_ANIMALS == actionType) {
            Log.i("it_onb", "ACTION_SUPPORT_WILD_ANIMALS");
        } else if (OnBoardingActionType.ACTION_SUPPORT_OCEAN_LIFE == actionType) {
            Log.i("it_onb", "ACTION_SUPPORT_OCEAN_LIFE");
        } else if (OnBoardingActionType.NO_ACTION_TYPE == actionType) {
            Log.i("it_onb", "NO_ACTION_TYPE");
        }
    }
}