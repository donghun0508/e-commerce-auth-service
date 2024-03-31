package com.example.auth.service.domain.exception;

public class MemberPasswordNotMatchedException extends AbstractAuthenticationException {

    public MemberPasswordNotMatchedException() {
        super(AuthenticationErrorCode.MEMBER_PASSWORD_NOT_MATCHED);
    }
}
