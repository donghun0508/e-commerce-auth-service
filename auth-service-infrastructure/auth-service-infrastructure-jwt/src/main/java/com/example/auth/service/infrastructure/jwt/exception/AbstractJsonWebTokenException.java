package com.example.auth.service.infrastructure.jwt.exception;

import com.example.auth.service.common.domain.exception.BaseAbstractAuthenticationException;

public abstract class AbstractJsonWebTokenException extends BaseAbstractAuthenticationException {
    protected AbstractJsonWebTokenException(JsonWebTokenErrorCode jsonWebTokenErrorCode) {
        super(jsonWebTokenErrorCode.getMessage(), jsonWebTokenErrorCode.getDetailMessage(), jsonWebTokenErrorCode.name(), jsonWebTokenErrorCode.getHttpStatusCode());
    }
}
