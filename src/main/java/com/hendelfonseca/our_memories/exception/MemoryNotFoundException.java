package com.hendelfonseca.our_memories.exception;

public class MemoryNotFoundException extends RuntimeException {
    public MemoryNotFoundException() {
        super("Memory not found");
    }

    public MemoryNotFoundException(String message) {
        super(message);
    }
}
