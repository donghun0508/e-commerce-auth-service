package com.example.auth.service.application.port.output;

import com.example.auth.service.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findByEmail(String email);
}
