package com.example.auth.service.adapter.web.request;

import com.example.auth.service.application.port.input.AuthenticationUseCase;
import lombok.Getter;

@Getter
public class LoginRequest {

    private String email;
    private String password;

    public AuthenticationUseCase.AuthenticationCommand toCommand() {
        return AuthenticationUseCase.AuthenticationCommand.builder()
                .email(email)
                .password(password)
                .build();
    }
}
