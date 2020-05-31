package com.yoji.listwithcustomelements.main;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({MainFragmentItem.HEALTH_MONITORING_SYSTEM, MainFragmentItem.NOTEBOOK,
        MainFragmentItem.SPLASH_SCREEN, MainFragmentItem.UNIVERSAL_INPUT_FORM,
        MainFragmentItem.VIEW_PHOTOS, MainFragmentItem.RADIOBUTTON_BY_CHECKBOXES,
        MainFragmentItem.COUNTRIES_CITIES_STREETS, MainFragmentItem.TASK_TIME_LIMITS})
public @interface MainFragmentItem {
    int HEALTH_MONITORING_SYSTEM = 0;
    int NOTEBOOK = 1;
    int SPLASH_SCREEN = 2;
    int UNIVERSAL_INPUT_FORM = 3;
    int VIEW_PHOTOS = 4;
    int RADIOBUTTON_BY_CHECKBOXES = 5;
    int COUNTRIES_CITIES_STREETS = 6;
    int TASK_TIME_LIMITS = 7;
}
