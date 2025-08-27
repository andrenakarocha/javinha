package com.dasa.dasa.domain.abstractions;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseEntity {

    private UUID id = UUID.randomUUID();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected BaseEntity() { }

    protected BaseEntity(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    protected void onCreate() {
        LocalDateTime now = this.getCurrentLocalDateTime();

        this.createdAt = now;
        this.updatedAt = now;
    }

    protected BaseEntity onUpdate() {
        this.updatedAt = this.getCurrentLocalDateTime();
        return this;
    }

    // --- Getters and Setters ---

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
}