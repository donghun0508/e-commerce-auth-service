package com.example.auth.service.domain.exception;

public class InvalidPasswordException extends AbstractAuthenticationException {

    public InvalidPasswordException() {
        super(AuthenticationErrorCode.INVALID_PASSWORD);
    }
}
