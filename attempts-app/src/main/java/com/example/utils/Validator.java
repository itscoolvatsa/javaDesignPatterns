package com.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static Pair<Boolean, String> ValidateName(String name) {
        if (name.length() >= 6 && name.length() <= 32) {
            return new Pair<>(true, "");
        } else {
            return new Pair<>(false, "name must be between or equal to 6 to 32 characters!!");
        }
    }

    public static Pair<Boolean, String> ValidateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()) {
            return new Pair<>(false, "please enter a valid email!!");

        }

        if (email.length() >= 6 && email.length() <= 120) {
            return new Pair<>(true, "");
        } else {
            return new Pair<>(false, "email must be between or equal to 6 to 120 characters!!");
        }
    }

    public static Pair<Boolean, String> ValidatePassword(String password) {

        if (password.length() >= 6 && password.length() <= 128) {
            return new Pair<>(true, "");
        } else {
            return new Pair<>(false, "password must be between or equal to 6 to 128 characters!!");
        }
    }
}
