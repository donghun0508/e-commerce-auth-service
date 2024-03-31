package com.example.auth.service.adapter.persistence.cache;

import com.example.auth.service.adapter.persistence.cache.domain.repository.JsonWebTokenCacheRepository;
import com.example.auth.service.adapter.persistence.cache.mapper.JsonWebTokenCacheMapper;
import com.example.auth.service.application.port.output.JsonWebTokenRepository;
import com.example.auth.service.common.domain.entity.AuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
class JsonWebTokenAdapter implements JsonWebTokenRepository {

    private final JsonWebTokenCacheMapper jsonWebTokenCacheMapper;
    private final JsonWebTokenCacheRepository jsonWebTokenCacheRepository;

    @Override
    public void save(AuthenticationToken authenticationToken) {
        jsonWebTokenCacheRepository.save(jsonWebTokenCacheMapper.accessTokenToEntity(authenticationToken));
        jsonWebTokenCacheRepository.save(jsonWebTokenCacheMapper.refreshTokenToEntity(authenticationToken));
    }
}
