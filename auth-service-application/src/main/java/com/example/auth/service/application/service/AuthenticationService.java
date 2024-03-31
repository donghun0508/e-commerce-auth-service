package com.example.auth.service.application.service;

import com.example.auth.service.application.port.input.AuthenticationUseCase;
import com.example.auth.service.application.port.output.JsonWebTokenRepository;
import com.example.auth.service.application.port.output.JsonWebTokenProvider;
import com.example.auth.service.application.port.output.MemberRepository;
import com.example.auth.service.application.port.output.PasswordEncoder;
import com.example.auth.service.common.domain.entity.AuthenticationToken;
import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.domain.exception.MemberNotFoundException;
import com.example.auth.service.domain.exception.MemberPasswordNotMatchedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class AuthenticationService implements AuthenticationUseCase {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JsonWebTokenProvider jsonWebTokenProvider;
    private final JsonWebTokenRepository jsonWebTokenRepository;

    @Override
    public AuthenticationTokenResponse authenticate(AuthenticationCommand command) {
        Member member = getMember(command);
        member.accountValidated();
        validatePassword(command, member);
        AuthenticationToken authenticationToken = jsonWebTokenProvider.generateTokens(member);
        jsonWebTokenRepository.save(authenticationToken);
        return createAuthenticationTokenResponse(authenticationToken);
    }

    private Member getMember(AuthenticationCommand command) {
        return memberRepository.findByEmail(command.email())
                .orElseThrow(MemberNotFoundException::new);
    }

    private void validatePassword(AuthenticationCommand command, Member member) {
        if (!passwordEncoder.matches(command.password(), member.getPassword().value())) {
            throw new MemberPasswordNotMatchedException();
        }
    }

    private AuthenticationTokenResponse createAuthenticationTokenResponse(AuthenticationToken authenticationToken) {
        return AuthenticationTokenResponse.builder()
                .accessToken(authenticationToken.accessToken().value())
                .refreshToken(authenticationToken.refreshToken().value())
                .build();
    }
}
