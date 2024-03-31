package com.example.auth.service.domain.exception;

import com.example.auth.service.common.domain.exception.BaseAbstractAuthenticationException;

public abstract class AbstractAuthenticationException extends BaseAbstractAuthenticationException {
    protected AbstractAuthenticationException(AuthenticationErrorCode authenticationErrorCode) {
        super(authenticationErrorCode.getMessage(), authenticationErrorCode.getDetailMessage(), authenticationErrorCode.name(), authenticationErrorCode.getHttpStatusCode());
    }
}
