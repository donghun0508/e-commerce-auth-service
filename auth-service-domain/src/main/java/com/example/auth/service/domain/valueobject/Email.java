package com.example.auth.service.domain.valueobject;


import com.example.auth.service.domain.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Email(String value) {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);


    public void validate() {
        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }
}
