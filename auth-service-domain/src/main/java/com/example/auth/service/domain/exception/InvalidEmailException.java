package com.example.auth.service.domain.exception;

public class InvalidEmailException extends AbstractAuthenticationException {

    public InvalidEmailException() {
        super(AuthenticationErrorCode.INVALID_EMAIL);
    }
}
