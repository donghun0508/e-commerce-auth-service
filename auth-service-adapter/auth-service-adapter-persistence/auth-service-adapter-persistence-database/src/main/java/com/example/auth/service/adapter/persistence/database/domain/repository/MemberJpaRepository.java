package com.example.auth.service.adapter.persistence.database.domain.repository;

import com.example.auth.service.adapter.persistence.database.domain.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
    Optional<MemberJpaEntity> findByEmail(String email);
}
