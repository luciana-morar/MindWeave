package com.mindweave.model;

import java.time.Instant;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;
    private final String email;
    private final String password;
    private final Instant createdAt;

    public User(UUID id, String username, String email, String password, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
