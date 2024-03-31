package com.example.auth.service.application.port.output;

import com.example.auth.service.common.domain.entity.AuthenticationToken;
import com.example.auth.service.domain.entity.Member;

public interface JsonWebTokenProvider {

    AuthenticationToken generateTokens(Member member);
}
