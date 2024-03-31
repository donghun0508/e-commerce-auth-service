package com.example.auth.service.infrastructure.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JsonWebTokenProperties {
    private String secret;
    private String issuer;
    private Expire expire;

    @Getter
    @Setter
    public static class Expire {
        private long accessToken;
        private long refreshToken;
    }
}
