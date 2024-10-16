package com.hendelfonseca.our_memories.controller;

import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> findAll() {
        return userService.readAll();
    }

    @GetMapping("/users/{id}")
    User findById(@PathVariable UUID id) {
        return userService.read(id);
    }

    @PostMapping("/users")
    User addUser(@RequestBody User newUser) {
        return userService.create(newUser);
    }

}
