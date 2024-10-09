package com.hendelfonseca.our_memories.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
