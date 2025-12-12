package com.pipocavagas.pipoca.mapper;

import com.pipocavagas.pipoca.dto.CreateUserDTO;
import com.pipocavagas.pipoca.model.User;

public class UserMapper {
    public static User toEntity(CreateUserDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }
}
