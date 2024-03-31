package com.example.auth.service.infrastructure.jwt.exception;

public class JsonWebTokenFactoryNotFoundException extends AbstractJsonWebTokenException {
    public JsonWebTokenFactoryNotFoundException() {
        super(JsonWebTokenErrorCode.FACTORY_NOT_FOUND);
    }
}
