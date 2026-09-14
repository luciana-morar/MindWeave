package com.mindweave.infrastructure;

import com.mindweave.model.User;

public class UserDTO {
    public static User toUserDTO(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreatedAt());
    }
}
