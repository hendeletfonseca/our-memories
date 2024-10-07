package com.hendelfonseca.our_memories.controller;

import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
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

    @PostMapping("/users/{userId}/memories/{memoryId}")
    User addMemoryToUser(@PathVariable UUID userId, @PathVariable long memoryId) {
        return userService.addMemoryToUser(userId, memoryId);
    }

}
