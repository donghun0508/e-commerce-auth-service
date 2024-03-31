package com.example.auth.service.adapter.web;

import com.example.auth.service.adapter.web.request.LoginRequest;
import com.example.auth.service.adapter.web.response.BaseResponse;
import com.example.auth.service.application.port.input.AuthenticationUseCase;
import com.example.auth.service.application.port.input.AuthenticationUseCase.AuthenticationTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationApiController {

    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/login")
    public BaseResponse<AuthenticationTokenResponse> login(@RequestBody LoginRequest request) {
        return BaseResponse.success(authenticationUseCase.authenticate(request.toCommand()));
    }
}
