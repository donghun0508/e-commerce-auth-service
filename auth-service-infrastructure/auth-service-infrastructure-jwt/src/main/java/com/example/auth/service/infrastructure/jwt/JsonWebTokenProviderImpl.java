package com.example.auth.service.infrastructure.jwt;

import com.example.auth.service.application.port.output.JsonWebTokenProvider;
import com.example.auth.service.common.domain.entity.AuthenticationToken;
import com.example.auth.service.common.domain.entity.JsonWebToken;
import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.infrastructure.jwt.provider.AuthenticationJsonWebTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
class JsonWebTokenProviderImpl implements JsonWebTokenProvider {

    private final AuthenticationJsonWebTokenProvider authenticationJsonWebTokenProvider;

    @Override
    public AuthenticationToken generateTokens(Member member) {
        JsonWebToken accessToken = authenticationJsonWebTokenProvider.createAccessToken(member);
        JsonWebToken refreshToken = authenticationJsonWebTokenProvider.createRefreshToken(member);
        return createAuthenticationToken(accessToken, refreshToken);
    }

    private AuthenticationToken createAuthenticationToken(JsonWebToken accessToken, JsonWebToken refreshToken) {
        return AuthenticationToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
