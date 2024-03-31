package com.example.auth.service.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthenticationErrorCode {

    MEMBER_NOT_FOUND(404, "Member not found", "Member not found"),
    MEMBER_ACCOUNT_DELETED(404, "Member account deleted", "Member account deleted"),
    MEMBER_PASSWORD_NOT_MATCHED(400, "Member password not matched", "Member password not matched"),
    INVALID_EMAIL(400, "INVALID_EMAIL", "Invalid email"),
    INVALID_PASSWORD(400, "INVALID_PASSWORD", "Invalid password"),
    INVALID_NICKNAME(400, "INVALID_NICKNAME", "Invalid nickname"),
    ;

    private final Integer httpStatusCode;
    private final String message;
    private final String detailMessage;
}
