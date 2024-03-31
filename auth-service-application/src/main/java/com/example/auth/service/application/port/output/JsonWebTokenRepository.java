package com.example.auth.service.application.port.output;

import com.example.auth.service.common.domain.entity.AuthenticationToken;

public interface JsonWebTokenRepository {
    void save(AuthenticationToken authenticationToken);
}
