package com.learning.lombok.controller;

import com.learning.lombok.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public User getData() {
        int id = 0;
        String name = "tarun", email = "tarun@gmail.com", password = "0000";
        User data = User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();

        return data;
    }
}
