package com.example.auth.service.adapter.persistence.database.mapper;

import com.example.auth.service.adapter.persistence.database.domain.entity.MemberJpaEntity;
import com.example.auth.service.common.domain.valueobject.MemberId;
import com.example.auth.service.domain.entity.Member;
import com.example.auth.service.domain.valueobject.Email;
import com.example.auth.service.domain.valueobject.Nickname;
import com.example.auth.service.domain.valueobject.Password;
import org.springframework.stereotype.Component;

@Component
public class MemberJpaMapper {
    public Member toDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .memberId(new MemberId(memberJpaEntity.getId()))
                .email(new Email(memberJpaEntity.getEmail()))
                .nickname(new Nickname(memberJpaEntity.getNickName()))
                .password(new Password(memberJpaEntity.getPassword()))
                .isDeleted(memberJpaEntity.isDeleted())
                .build();
    }
}
