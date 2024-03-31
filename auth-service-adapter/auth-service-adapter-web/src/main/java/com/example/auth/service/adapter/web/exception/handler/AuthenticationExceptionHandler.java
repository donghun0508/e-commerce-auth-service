package com.example.auth.service.adapter.web.exception.handler;

import com.example.auth.service.adapter.web.response.ErrorResponse;
import com.example.auth.service.common.domain.exception.BaseAbstractAuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@Slf4j
@RestControllerAdvice
public class AuthenticationExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse.builder()
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler(BaseAbstractAuthenticationException.class)
    public ResponseEntity<ErrorResponse> authenticationAdminExceptionHandler(BaseAbstractAuthenticationException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(e.getHttpStatusCode())
            .body(ErrorResponse.builder()
                .message(e.getMessage())
                .detailMessage(e.getDetailMessage())
                .errorCode(e.getErrorCode())
                .build());
    }

}
