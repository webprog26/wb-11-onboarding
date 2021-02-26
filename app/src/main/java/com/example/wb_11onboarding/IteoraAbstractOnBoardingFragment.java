package com.example.wb_11onboarding;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class IteoraAbstractOnBoardingFragment extends Fragment implements View.OnClickListener {

    private static final int NO_VIEW_NEXT_FOUND = -1;
    private static final int NO_VIEW_ACTION_FOUND = -2;

    private static final int NO_VIEW_ACTIVE_BACKGROUND_FOUND = -3;
    private static final int NO_VIEW_INACTIVE_BACKGROUND_FOUND = -4;


    private View vPrimaryAction;
    private View vSecondaryAction;

    private IteoraOnBoardingCallback callback;

    @Override
    public final void onAttach(Context context) {
        super.onAttach(context);
        super.onAttach(context);
        if (context instanceof IteoraOnBoardingCallback) {
            callback = (IteoraOnBoardingCallback) context;
        }
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public final void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewCreatedInternal(view);

        if (callback != null) {
            final int vNextId = getViewNextId();
            if (vNextId != NO_VIEW_NEXT_FOUND) {
                final View vNext = view.findViewById(vNextId);
                if (vNext != null) {
                    vNext.setOnClickListener((v) -> {
                        callback.onNextClicked();
                    });
                }
            }

            final int vPrimaryActionId = getViewPrimaryActionId();
            final int vSecondaryActionId = getViewSecondaryActionId();

            if (vPrimaryActionId != NO_VIEW_ACTION_FOUND) {
                vPrimaryAction = view.findViewById(vPrimaryActionId);
                if (vPrimaryAction != null) {
                    vPrimaryAction.setOnClickListener(this);
                }
            }


            if (vSecondaryActionId != NO_VIEW_ACTION_FOUND) {
                vSecondaryAction = view.findViewById(vSecondaryActionId);
                if (vSecondaryAction != null) {
                    vSecondaryAction.setOnClickListener(this);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (callback != null) {
            if (id == getViewNextId()) {
                callback.onNextClicked();
            } else if (id == getViewPrimaryActionId()) {
                final Object tag = v.getTag();
                if (tag != null) {
                    final boolean isActive = Boolean.parseBoolean(String.valueOf(v.getTag()));
                    v.setTag(!isActive);
                    if (vSecondaryAction != null) {
                        vSecondaryAction.setTag(false);
                    }
                } else {
                    vPrimaryAction.setTag(Boolean.valueOf("true"));
                }
                callback.onActionClicked(getPrimaryActionType());
            } else if (id == getViewSecondaryActionId()) {
                final Object tag = v.getTag();
                if (tag != null) {
                    final boolean isActive = Boolean.parseBoolean(String.valueOf(v.getTag()));
                    v.setTag(!isActive);
                    if (vPrimaryAction != null) {
                        vPrimaryAction.setTag(false);
                    }
                } else {
                    vSecondaryAction.setTag(Boolean.valueOf("true"));
                }
                callback.onActionClicked(getSecondaryActionType());
            }
        }
        maybeManageActionViewsBackground(id);
    }

    private void maybeManageActionViewsBackground(final int id) {
        if (vPrimaryAction instanceof IteoraSelectableFirstRunImageView && vSecondaryAction instanceof IteoraSelectableFirstRunImageView) {
            final Context context = getContext();
            if (context != null) {
                final int viewActiveBackground = getViewActiveBackground();
                final int viewInactiveBackground = getViewInactiveBackground();
                if (viewActiveBackground != NO_VIEW_ACTIVE_BACKGROUND_FOUND && viewInactiveBackground != NO_VIEW_INACTIVE_BACKGROUND_FOUND) {
                    if (vPrimaryAction.getId() == id) {
                        if (isViewSelected(vPrimaryAction.getTag())) {
                            ((IteoraSelectableFirstRunImageView) vPrimaryAction).onViewSelected();
                            ((IteoraSelectableFirstRunImageView) vSecondaryAction).onViewDeselected();

                        } else {
                            ((IteoraSelectableFirstRunImageView) vPrimaryAction).onViewDeselected();
                        }
                    } else if (vSecondaryAction.getId() == id) {
                        if (isViewSelected(vSecondaryAction.getTag())) {
                            ((IteoraSelectableFirstRunImageView) vSecondaryAction).onViewSelected();
                            ((IteoraSelectableFirstRunImageView) vPrimaryAction).onViewDeselected();
                        } else {
                            ((IteoraSelectableFirstRunImageView) vSecondaryAction).onViewDeselected();
                        }
                    }
                }
            }
        }
    }

    private static boolean isViewSelected(final Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return false;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void onViewCreatedInternal(final View view);

    protected int getViewNextId() {
        return NO_VIEW_NEXT_FOUND;
    }

    protected int getViewPrimaryActionId() {
        return NO_VIEW_ACTION_FOUND;
    }

    protected int getViewSecondaryActionId() {
        return NO_VIEW_ACTION_FOUND;
    }

    @IteoraOnBoardingCallback.OnBoardingActionType
    protected int getPrimaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.NO_ACTION_TYPE;
    }

    @IteoraOnBoardingCallback.OnBoardingActionType
    protected int getSecondaryActionType() {
        return IteoraOnBoardingCallback.OnBoardingActionType.NO_ACTION_TYPE;
    }

    protected int getViewActiveBackground() {
        return NO_VIEW_ACTIVE_BACKGROUND_FOUND;
    }

    protected int getViewInactiveBackground() {
        return NO_VIEW_INACTIVE_BACKGROUND_FOUND;
    }

    protected Spanned parseHtmlString(int htmlStringResId) {
        return Html.fromHtml(getString(htmlStringResId));
    }
}
