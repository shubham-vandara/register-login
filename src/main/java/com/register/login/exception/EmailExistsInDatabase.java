package com.register.login.exception;

public class EmailExistsInDatabase extends RuntimeException {

    public EmailExistsInDatabase(String message) {
        super(message);
    }
}
