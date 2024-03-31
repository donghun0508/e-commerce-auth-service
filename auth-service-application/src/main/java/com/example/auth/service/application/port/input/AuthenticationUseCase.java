package com.example.auth.service.application.port.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import static com.example.auth.service.common.validate.Validation.validate;

public interface AuthenticationUseCase {

    AuthenticationTokenResponse authenticate(AuthenticationCommand command);

    @Builder
    record AuthenticationCommand(
            @NotBlank String email,
            @NotBlank String password
    ) {
        public AuthenticationCommand(@NotBlank String email, @NotBlank String password) {
            this.email = email;
            this.password = password;

            validate(this);
        }
    }

    @Builder
    record AuthenticationTokenResponse(
            String accessToken,
            String refreshToken
    ) {
        public AuthenticationTokenResponse(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }
}
