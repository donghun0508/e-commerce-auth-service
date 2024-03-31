package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenInvalidException extends JsonWebTokenException {

    public JsonWebTokenInvalidException() {
        super(JsonWebTokenErrorCode.INVALID_TOKEN);
    }
}
