package com.mindweave.infrastructure.service;

import com.mindweave.infrastructure.UserDTO;
import com.mindweave.infrastructure.UserEntity;
import com.mindweave.infrastructure.UserJpaRepository;
import com.mindweave.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserJpaRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String username, String email, String rawPassword) {
        try {
            String hash = passwordEncoder.encode(rawPassword);
            UserEntity saved = userRepository.save(new UserEntity(username, email, hash));
            return UserDTO.toUserDTO(saved);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Username sau email deja folosit");
        }
    }
}