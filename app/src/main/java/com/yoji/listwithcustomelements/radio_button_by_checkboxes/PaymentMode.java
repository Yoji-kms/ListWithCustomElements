package com.yoji.listwithcustomelements.radio_button_by_checkboxes;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({PaymentMode.BY_CARD, PaymentMode.BY_CASH, PaymentMode.BY_PHONE})
public @interface PaymentMode {
    int BY_CARD = 0;
    int BY_PHONE = 1;
    int BY_CASH = 2;
}
