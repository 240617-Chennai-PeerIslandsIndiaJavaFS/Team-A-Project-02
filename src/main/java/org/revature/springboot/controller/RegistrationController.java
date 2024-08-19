package org.revature.springboot.controller;

import org.revature.springboot.model.User;
import org.revature.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }
}
