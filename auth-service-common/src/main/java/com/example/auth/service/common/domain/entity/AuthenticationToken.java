package com.example.auth.service.common.domain.entity;

import lombok.Builder;

@Builder
public record AuthenticationToken(
        JsonWebToken accessToken,
        JsonWebToken refreshToken
) {
}
