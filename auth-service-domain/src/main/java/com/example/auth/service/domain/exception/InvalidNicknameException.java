package com.example.auth.service.domain.exception;

public class InvalidNicknameException extends AbstractAuthenticationException {

    public InvalidNicknameException() {
        super(AuthenticationErrorCode.INVALID_NICKNAME);
    }
}
