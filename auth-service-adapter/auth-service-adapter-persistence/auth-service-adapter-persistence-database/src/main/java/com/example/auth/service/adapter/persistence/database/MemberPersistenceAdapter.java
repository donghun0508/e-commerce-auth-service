package com.example.auth.service.adapter.persistence.database;

import com.example.auth.service.adapter.persistence.database.domain.repository.MemberJpaRepository;
import com.example.auth.service.adapter.persistence.database.mapper.MemberJpaMapper;
import com.example.auth.service.application.port.output.MemberRepository;
import com.example.auth.service.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
class MemberPersistenceAdapter implements MemberRepository {

    private final MemberJpaMapper memberJpaMapper;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmail(email)
                .map(memberJpaMapper::toDomainEntity);
    }
}
