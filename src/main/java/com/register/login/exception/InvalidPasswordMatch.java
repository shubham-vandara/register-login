package com.register.login.exception;

public class InvalidPasswordMatch extends RuntimeException {

    public InvalidPasswordMatch(String message) {
        super(message);
    }

}
