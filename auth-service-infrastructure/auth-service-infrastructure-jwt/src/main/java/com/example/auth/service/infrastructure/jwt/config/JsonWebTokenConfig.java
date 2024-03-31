package com.example.auth.service.infrastructure.jwt.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@RequiredArgsConstructor
@Configuration
public class JsonWebTokenConfig {

    private final JsonWebTokenProperties jsonWebTokenProperties;

    @Bean
    Key secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jsonWebTokenProperties.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
