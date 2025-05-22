package com.example.blackdiamond.exception;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorResponse> HandleUserNotFoundException(UserNotFoundException exception) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorcode = "Error";
        System.out.println(exception.getMessage());
        String errorMessage = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(status.value(), errorcode, errorMessage);
        return ResponseEntity.status(status).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
