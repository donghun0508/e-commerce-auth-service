package com.example.auth.service.adapter.persistence.cache.mapper;

import com.example.auth.service.adapter.persistence.cache.domain.entity.JsonWebTokenCacheEntity;
import com.example.auth.service.common.domain.entity.AuthenticationToken;
import com.example.auth.service.common.domain.valueobject.JsonWebTokenType;
import org.springframework.stereotype.Component;

@Component
public class JsonWebTokenCacheMapper {

    public JsonWebTokenCacheEntity accessTokenToEntity(AuthenticationToken authenticationToken) {
        return JsonWebTokenCacheEntity.builder()
                .value(authenticationToken.accessToken().value())
                .type(JsonWebTokenType.ACCESS_TOKEN)
                .build();
    }

    public JsonWebTokenCacheEntity refreshTokenToEntity(AuthenticationToken authenticationToken) {
        return JsonWebTokenCacheEntity.builder()
                .value(authenticationToken.refreshToken().value())
                .type(JsonWebTokenType.REFRESH_TOKEN)
                .build();
    }
}
