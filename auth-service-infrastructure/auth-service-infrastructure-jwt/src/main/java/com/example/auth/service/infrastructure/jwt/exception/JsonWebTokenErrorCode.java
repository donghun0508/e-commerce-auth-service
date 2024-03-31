package com.example.auth.service.infrastructure.jwt.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JsonWebTokenErrorCode {
    INVALID_TOKEN(401, "Invalid token", "The token is invalid."),
    EXPIRED_TOKEN(401, "Expired token", "The token has expired."),
    INVALID_SIGNATURE(401, "Invalid signature", "The token signature is invalid."),
    INVALID_CLAIM(401, "Invalid claim", "The token claim is invalid."),
    INVALID_ISSUER(401, "Invalid issuer", "The token issuer is invalid."),
    INVALID_AUDIENCE(401, "Invalid audience", "The token audience is invalid."),
    INVALID_SUBJECT(401, "Invalid subject", "The token subject is invalid."),
    INVALID_ISSUED_AT(401, "Invalid issued at", "The token issued at is invalid."),
    INVALID_EXPIRATION(401, "Invalid expiration", "The token expiration is invalid."),
    INVALID_NOT_BEFORE(401, "Invalid not before", "The token not before is invalid."),
    INVALID_JWT_ID(401, "Invalid JWT ID", "The token JWT ID is invalid."),
    NOT_SUPPORTED(401, "Not supported", "The token is not supported."),
    FACTORY_NOT_FOUND(500, "JsonWebTokenFactory not found", "The JsonWebTokenFactory is not found."),
    ;

    private final Integer httpStatusCode;
    private final String message;
    private final String detailMessage;
}
