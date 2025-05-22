package com.example.blackdiamond.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String user, int id) {
        super(user + "  ID: " + id);
        log.error("Missing user id :{}", id);
    }
}
