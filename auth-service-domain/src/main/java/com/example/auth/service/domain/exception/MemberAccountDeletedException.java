package com.example.auth.service.domain.exception;

public class MemberAccountDeletedException extends AbstractAuthenticationException {
    public MemberAccountDeletedException() {
        super(AuthenticationErrorCode.MEMBER_ACCOUNT_DELETED);
    }
}
