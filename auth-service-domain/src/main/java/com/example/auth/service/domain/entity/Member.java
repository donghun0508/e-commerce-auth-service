package com.example.auth.service.domain.entity;

import com.example.auth.service.common.domain.entity.AggregateRoot;
import com.example.auth.service.common.domain.valueobject.MemberId;
import com.example.auth.service.domain.exception.MemberAccountDeletedException;
import com.example.auth.service.domain.valueobject.Email;
import com.example.auth.service.domain.valueobject.Nickname;
import com.example.auth.service.domain.valueobject.Password;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member extends AggregateRoot<MemberId> {

    private final Email email;
    private Nickname nickname;
    private Password password;
    private boolean isDeleted;

    @Builder
    private Member(MemberId memberId, Email email, Nickname nickname, Password password, boolean isDeleted) {
        super.setId(memberId);
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.isDeleted = isDeleted;
    }

    public void accountValidated() {

        if(this.isDeleted) {
            throw new MemberAccountDeletedException();
        }

    }
}
