package com.example.auth.service.infrastructure.jwt.provider;

import com.example.auth.service.common.domain.entity.JsonWebToken;
import com.example.auth.service.common.domain.valueobject.JsonWebTokenType;
import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.infrastructure.jwt.config.JsonWebTokenProperties;
import com.example.auth.service.infrastructure.jwt.exception.*;
import com.example.auth.service.infrastructure.jwt.factory.AbstractJsonWebTokenFactory;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthenticationJsonWebTokenProviderImpl implements AuthenticationJsonWebTokenProvider {

    private final JsonWebTokenProperties jsonWebTokenProperties;
    private final List<AbstractJsonWebTokenFactory> jsonWebTokenFactories;
    private final Key key;

    public void validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.debug("잘못된 JWT 서명입니다.");
            throw new JsonWebTokenInvalidSignatureException();
        } catch (ExpiredJwtException e) {
            log.debug("만료된 JWT 토큰입니다.");
            throw new JsonWebTokenExpiredException();
        } catch (UnsupportedJwtException e) {
            log.debug("지원되지 않는 JWT 토큰입니다.");
            throw new JsonWebTokenNotSupportedException();
        } catch (IllegalArgumentException e) {
            log.debug("JWT 토큰이 잘못되었습니다.");
            throw new JsonWebTokenInvalidException();
        }
    }

    @Override
    public JsonWebToken createAccessToken(Member member) {
        String token = createToken(member, JsonWebTokenType.ACCESS_TOKEN);
        return new JsonWebToken(token);
    }

    @Override
    public JsonWebToken createRefreshToken(Member member) {
        String token = createToken(member, JsonWebTokenType.REFRESH_TOKEN);
        return new JsonWebToken(token);
    }

    private String createToken(Member member, JsonWebTokenType jsonWebTokenType) {
        return jsonWebTokenFactories.stream()
                .filter(factory -> factory.isSupport(jsonWebTokenType))
                .findFirst()
                .orElseThrow(JsonWebTokenFactoryNotFoundException::new)
                .createToken(member);
    }
}
