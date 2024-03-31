package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenException extends AbstractJsonWebTokenException {

    protected JsonWebTokenException(JsonWebTokenErrorCode jsonWebTokenErrorCode) {
        super(jsonWebTokenErrorCode);
    }
}
