package com.example.springtestdemo.controller;

import com.example.springtestdemo.model.AddUserRequest;
import com.example.springtestdemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.experimental.results.ResultMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
class CategoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void it_should_add_user() throws Exception {
        AddUserRequest addUserRequest = AddUserRequest.builder().name("Ahmet").age(35).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestContent = objectMapper.writeValueAsString(addUserRequest);
        mockMvc.perform(post("/user/add")
                .content(requestContent)
                .contentType(MediaType.APPLICATION_JSON));
        verify(userService).addUser(addUserRequest);

    }
}