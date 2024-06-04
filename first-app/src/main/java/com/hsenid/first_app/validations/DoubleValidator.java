package com.hsenid.first_app.validations;

public class DoubleValidator {
    public static boolean isValid(double input) {
        // Check if the input is not infinity or NaN
        return !Double.isInfinite(input) && !Double.isNaN(input);
    }
}