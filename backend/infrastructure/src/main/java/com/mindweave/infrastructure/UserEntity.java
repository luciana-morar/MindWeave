package com.mindweave.infrastructure;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name= "users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(nullable = false, unique = true) private String username;
    @Column(nullable = false, unique = true) private String email;
    @Column(name = "password", nullable = false) private String password;
    @Column(name = "created_at") private Instant createdAt;

    protected UserEntity() {}
    public UserEntity(String username, String email, String password) {
        this.username = username; this.email = email;
        this.password = password; this.createdAt = Instant.now();
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
