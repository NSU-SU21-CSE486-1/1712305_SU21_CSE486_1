package com.hmtsoft.uniclubz.utils;

import java.util.regex.Pattern;

public class Utils {

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

}
