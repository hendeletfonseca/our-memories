package com.hendelfonseca.our_memories.exception;

import org.springframework.http.HttpStatus;

public class MemoryNotFoundException extends RuntimeException {

    public MemoryNotFoundException(String message) {
        super(message);
    }

}
