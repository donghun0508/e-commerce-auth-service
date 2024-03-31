package com.example.auth.service.infrastructure.jwt.provider;

import com.example.auth.service.common.domain.entity.JsonWebToken;
import com.example.auth.service.domain.entity.Member;

public interface AuthenticationJsonWebTokenProvider {

    JsonWebToken createAccessToken(Member member);
    JsonWebToken createRefreshToken(Member member);
}
