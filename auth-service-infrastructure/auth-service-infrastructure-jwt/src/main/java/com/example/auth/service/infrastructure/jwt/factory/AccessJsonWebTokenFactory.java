package com.example.auth.service.infrastructure.jwt.factory;

import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.infrastructure.jwt.config.JsonWebTokenProperties;
import com.example.auth.service.common.domain.valueobject.JsonWebTokenType;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessJsonWebTokenFactory extends AbstractJsonWebTokenFactory {

    public AccessJsonWebTokenFactory(JsonWebTokenProperties jsonWebTokenProperties, Key key) {
        super(jsonWebTokenProperties, key);
    }

    @Override
    public boolean isSupport(JsonWebTokenType jsonWebTokenType) {
        return jsonWebTokenType.equals(JsonWebTokenType.ACCESS_TOKEN);
    }

    @Override
    protected long getTokenExpirationTimeInMilliseconds() {
        return super.jsonWebTokenProperties.getExpire().getAccessToken();
    }

    @Override
    protected Map<String, String> createClaims(Member member) {
        Map<String, String> claims = new HashMap<>();
        claims.put("type", JsonWebTokenType.ACCESS_TOKEN.name());
        return claims;
    }
}
