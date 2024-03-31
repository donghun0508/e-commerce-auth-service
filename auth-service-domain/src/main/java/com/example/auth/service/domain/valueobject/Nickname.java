package com.example.auth.service.domain.valueobject;


import com.example.auth.service.domain.exception.InvalidNicknameException;

public record Nickname(String value) {
    public void validate() {
        if(value.length() < 2 || value.length() > 10) {
            throw new InvalidNicknameException();
        }
    }
}
