package com.hendelfonseca.our_memories.controller;

import com.hendelfonseca.our_memories.model.User;
import com.hendelfonseca.our_memories.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = new ArrayList<>(userService.readAll());

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.read(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        User user = userService.create(new User(newUser.getUsername()));
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
