package com.example.springtestdemo.service;

import com.example.springtestdemo.domain.UserEntity;
import com.example.springtestdemo.model.AddUserRequest;
import com.example.springtestdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean addUser(AddUserRequest addUserRequest) {
        Optional.ofNullable(addUserRequest)
                .filter(addUserRequest1 -> Optional.ofNullable(addUserRequest1.getName()).isPresent())
                .ifPresent(userName -> {
                    UserEntity newUser = UserEntity.builder().name(addUserRequest.getName()).age(addUserRequest.getAge()).build();

                    userRepository.save(newUser);

                    UserEntity newUser2 = UserEntity.builder().name(newUser.getName()).age(54).build();

                    userRepository.save(newUser2);

                    UserEntity newUser3 = UserEntity.builder().name("Kamil").age(addUserRequest.getAge()).build();

                    userRepository.save(newUser3);

                });
        return true;
    }
}
