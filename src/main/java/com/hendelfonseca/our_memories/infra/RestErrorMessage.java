package com.hendelfonseca.our_memories.infra;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
    private final HttpStatus status;
    private final String message;

    public RestErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
