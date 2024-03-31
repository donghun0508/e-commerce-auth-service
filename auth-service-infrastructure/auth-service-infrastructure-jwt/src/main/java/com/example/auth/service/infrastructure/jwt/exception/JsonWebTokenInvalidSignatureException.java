package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenInvalidSignatureException extends JsonWebTokenException {
    public JsonWebTokenInvalidSignatureException() {
        super(JsonWebTokenErrorCode.INVALID_SIGNATURE);
    }
}
