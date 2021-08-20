package com.hmtsoft.uniclubz.utils;

import android.widget.Toast;

import androidx.annotation.StringRes;

import com.hmtsoft.uniclubz.App;


public class ToastUtils {

    public static void show(String message) {
        if (App.getContext() != null)
            Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void show(String message, boolean isLong) {
        if (App.getContext() != null)
            Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void show(@StringRes int resId) {
        if (App.getContext() != null)
            show(App.getContext().getText(resId).toString());
    }

    public static void show(@StringRes int resId, boolean isLong) {
        if (App.getContext() != null)
            show(App.getContext().getText(resId).toString(), isLong);
    }

}
