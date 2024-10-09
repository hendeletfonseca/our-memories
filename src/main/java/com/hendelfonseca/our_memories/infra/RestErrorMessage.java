package com.hendelfonseca.our_memories.infra;

import java.util.Date;

public class RestErrorMessage {
    private final int statusCode;
    private final Date timestamp;
    private final String message;
    private final String description;

    public RestErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
