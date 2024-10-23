package com.hendelfonseca.our_memories.infra;

import com.hendelfonseca.our_memories.exception.MemoryNotFoundException;
import com.hendelfonseca.our_memories.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemoryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public RestErrorMessage resourceNotFoundException(MemoryNotFoundException ex, WebRequest request) {
        return new RestErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public RestErrorMessage resourceNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new RestErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorMessage exception(Exception ex, WebRequest request) {
        return new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

}
