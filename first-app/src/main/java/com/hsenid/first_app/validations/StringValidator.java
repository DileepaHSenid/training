package com.hsenid.first_app.validations;

import java.util.regex.Pattern;

public class StringValidator {
    private static final Pattern STRING_PATTERN = Pattern.compile("^[\\p{L}\\p{M}\\s'.,?!-]+$");

    public static boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return STRING_PATTERN.matcher(input).matches();
    }
}