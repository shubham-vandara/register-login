package com.register.login.exception;


public class InvalidLoginPassword extends RuntimeException {

    public InvalidLoginPassword(String message) {
        super(message);
    }
}
