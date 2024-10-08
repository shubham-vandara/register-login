package com.register.login.exception;

public class InvalidLoginEmail extends RuntimeException {

    public InvalidLoginEmail(String message) {
        super(message);
    }
}
