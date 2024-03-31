package com.example.auth.service.adapter.persistence.database.domain.entity;

import com.example.auth.service.domain.valueobject.Action;
import com.example.auth.service.domain.valueobject.ResourceType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "permission")
public class PermissionJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;

    private Long orderNumber;
    private String resource;
    private String description;
    @Enumerated(EnumType.STRING)
    private Action action;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @Builder
    private PermissionJpaEntity(Long id, Long orderNumber, String resource, String description, Action action, ResourceType resourceType) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.resource = resource;
        this.description = description;
        this.action = action;
        this.resourceType = resourceType;
    }
}
