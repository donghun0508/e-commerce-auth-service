package com.example.auth.service.adapter.persistence.cache.domain.entity;

import com.example.auth.service.common.domain.valueobject.JsonWebTokenType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@RedisHash("JsonWebToken")
public class JsonWebTokenCacheEntity implements Serializable {

    @Id
    private final String value;
    private final JsonWebTokenType type;

    @Builder
    private JsonWebTokenCacheEntity(String value, JsonWebTokenType type) {
        this.value = value;
        this.type = type;
    }
}
