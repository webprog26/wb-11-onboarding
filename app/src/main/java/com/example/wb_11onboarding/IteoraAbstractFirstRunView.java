package com.example.wb_11onboarding;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public abstract class IteoraAbstractFirstRunView extends LinearLayout {

    public IteoraAbstractFirstRunView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(final Context context, @Nullable final AttributeSet attrs) {
        setOrientation(VERTICAL);
        final View rootView = LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        onPostInit(rootView, attrs);
    }

    protected abstract int getLayoutResId();

    protected abstract void onPostInit(final View rootView, @Nullable final AttributeSet attrs);
}
