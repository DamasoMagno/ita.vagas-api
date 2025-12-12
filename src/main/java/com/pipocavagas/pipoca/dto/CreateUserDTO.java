package com.pipocavagas.pipoca.dto;

public record CreateUserDTO(
        String name,
        String email,
        String password
) {
}
