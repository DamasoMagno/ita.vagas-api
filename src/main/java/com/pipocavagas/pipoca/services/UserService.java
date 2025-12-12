package com.pipocavagas.pipoca.services;

import com.pipocavagas.pipoca.mapper.UserMapper;
import com.pipocavagas.pipoca.model.User;
import com.pipocavagas.pipoca.dto.CreateUserDTO;
import com.pipocavagas.pipoca.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public User findUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new Error("Usuário não encontrado"));
    }

    public void createUser(CreateUserDTO user){
        User newUser = UserMapper.toEntity(user);
        userRepository.save(newUser);
    }

    public void updateUser(Long UserId, User updateUserDTO){
        userRepository.findById(UserId).orElseThrow(() ->
            new Error("Empresa não encontrada")
        );

        userRepository.save(updateUserDTO);
    }

    public void deleteUser(Long UserId){
        userRepository.deleteById(UserId);
    }
}
