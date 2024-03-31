package com.example.auth.service.adapter.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String message;
    private final String errorCode;
    private String detailMessage;
    private String stackTrace;
    private List<ValidationError> errors;

    @Builder
    public ErrorResponse(String message, String errorCode, String detailMessage, String stackTrace, List<ValidationError> errors) {
        this.message = message;
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
        this.stackTrace = stackTrace;
        this.errors = errors;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationError {
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}