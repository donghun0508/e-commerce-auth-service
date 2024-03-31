package com.example.auth.service.domain.exception;

public class MemberNotFoundException extends AbstractAuthenticationException {
    public MemberNotFoundException() {
        super(AuthenticationErrorCode.MEMBER_NOT_FOUND);
    }
}
