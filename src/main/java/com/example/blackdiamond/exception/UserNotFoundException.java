package com.example.blackdiamond.exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }


    public UserNotFoundException(String user,int id) {
        super(  user + "  ID: " + id);    }
}
