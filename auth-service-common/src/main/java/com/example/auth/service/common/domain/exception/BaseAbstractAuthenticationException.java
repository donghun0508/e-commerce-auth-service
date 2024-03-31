package com.example.auth.service.common.domain.exception;

import lombok.Getter;

@Getter
public abstract class BaseAbstractAuthenticationException extends RuntimeException {

    private final String message;
    private final String detailMessage;
    private final String errorCode;
    private final Integer httpStatusCode;

    protected BaseAbstractAuthenticationException(String message, String detailMessage, String errorCode, Integer httpStatusCode) {
        this.message = message;
        this.detailMessage = detailMessage;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }
}
