package com.example.auth.service.adapter.persistence.database.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class MemberJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String nickName;
    private boolean isDeleted;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Setter private List<GroupMemberJpaEntity> groupMembers = new ArrayList<>();

    @Builder
    private MemberJpaEntity(Long id, String email, String password, String nickName, boolean isDeleted, LocalDateTime deletedAt, List<GroupMemberJpaEntity> groupMembers) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.isDeleted = isDeleted;
        this.deletedAt = deletedAt;
        this.groupMembers = groupMembers;
    }
}
