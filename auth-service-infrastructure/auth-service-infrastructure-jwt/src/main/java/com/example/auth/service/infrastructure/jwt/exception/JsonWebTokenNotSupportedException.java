package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenNotSupportedException extends JsonWebTokenException {

    public JsonWebTokenNotSupportedException() {
        super(JsonWebTokenErrorCode.NOT_SUPPORTED);
    }
}
