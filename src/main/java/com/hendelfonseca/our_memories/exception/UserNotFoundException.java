package com.hendelfonseca.our_memories.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    private UUID userId;

    public UserNotFoundException(UUID userId) {
        super("User not found with id: " + userId);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
