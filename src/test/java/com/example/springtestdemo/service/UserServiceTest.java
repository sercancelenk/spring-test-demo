package com.example.springtestdemo.service;

import com.example.springtestdemo.domain.UserEntity;
import com.example.springtestdemo.model.AddUserRequest;
import com.example.springtestdemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void it_should_addUser_when_name_and_age_not_null() {
        //given
        AddUserRequest addUserRequest = AddUserRequest.builder().name("Ahmet").age(35).build();
        UserEntity user = UserEntity.builder().name(addUserRequest.getName()).age(addUserRequest.getAge()).build();
        given(userRepository.save(user)).willReturn(user);
        //when
        userService.addUser(addUserRequest);
        //then
        ArgumentCaptor<UserEntity> userCapture = ArgumentCaptor.forClass(UserEntity.class);

        verify(userRepository, times(3)).save(userCapture.capture());

        List<UserEntity> allValues = userCapture.getAllValues();
        assertThat(allValues.get(0).getAge()).isEqualTo(35);
        assertThat(allValues.get(1).getAge()).isEqualTo(54);
        assertThat(allValues.get(2).getAge()).isEqualTo(35);
    }

}