package com.example.blackdiamond.exception;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorResponse> HandleUserNotFoundException(UserNotFoundException exception){
    HttpStatus status =HttpStatus.INTERNAL_SERVER_ERROR;
    String errorcode="Error";
    System.out.println(exception.getMessage());
    String errorMessage=exception.getMessage();
    ErrorResponse errorResponse=new ErrorResponse(status.value(), errorcode,errorMessage);
    return ResponseEntity.status(status).body(errorResponse);
    }
}
