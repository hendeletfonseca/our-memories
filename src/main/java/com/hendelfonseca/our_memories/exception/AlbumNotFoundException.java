package com.hendelfonseca.our_memories.exception;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException() {
        super("Album not found");
    }

    public AlbumNotFoundException(String message) {
        super(message);
    }

    public AlbumNotFoundException(long albumId) {
        super("Album not found with id: " + albumId);
    }
}
