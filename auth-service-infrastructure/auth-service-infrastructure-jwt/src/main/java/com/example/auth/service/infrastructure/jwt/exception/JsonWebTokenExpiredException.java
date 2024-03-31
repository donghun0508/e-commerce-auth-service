package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenExpiredException extends JsonWebTokenException {

    public JsonWebTokenExpiredException() {
        super(JsonWebTokenErrorCode.EXPIRED_TOKEN);
    }
}
