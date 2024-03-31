package com.example.auth.service.common.domain.event;

import java.time.LocalDateTime;

public abstract class DomainEvent {
    private final LocalDateTime eventDateAt;

    public DomainEvent(LocalDateTime eventDateAt) {
        this.eventDateAt = eventDateAt;
    }
}
