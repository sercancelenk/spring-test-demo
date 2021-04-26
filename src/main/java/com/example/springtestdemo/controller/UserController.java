package com.example.springtestdemo.controller;

import com.example.springtestdemo.model.AddUserRequest;
import com.example.springtestdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("add")
    public void addUser(@RequestBody AddUserRequest addUserRequest){
        userService.addUser(addUserRequest);
    }
}
