package com.example.auth.service.infrastructure.jwt.factory;


import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.infrastructure.jwt.config.JsonWebTokenProperties;
import com.example.auth.service.common.domain.valueobject.JsonWebTokenType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public abstract class AbstractJsonWebTokenFactory {

    protected final JsonWebTokenProperties jsonWebTokenProperties;
    protected final Key key;

    public String createToken(Member member) {
        Date currentDate = new Date();
        long now = currentDate.getTime();
        Date validity = new Date(now + getTokenExpirationTimeInMilliseconds());

        Map<String, String> map = createDefaultClaims(member);
        map.putAll(createClaims(member));
        return toJwtString(currentDate, map, validity);
    }

    private Map<String, String> createDefaultClaims(Member member) {
        Map<String, String> claims = new HashMap<>();
        claims.put("email", member.getEmail().value());
        claims.put("nickname", member.getNickname().value());
        return claims;
    }

    private String toJwtString(Date currentDate, Map<String, String> map, Date validity) {
        return Jwts.builder()
                .setIssuer(jsonWebTokenProperties.getIssuer())
                .setIssuedAt(currentDate)
                .setClaims(map)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    public abstract boolean isSupport(JsonWebTokenType jsonWebTokenType);
    protected abstract long getTokenExpirationTimeInMilliseconds();
    protected abstract Map<String, String> createClaims(Member member);
}
