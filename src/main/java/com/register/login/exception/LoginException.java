package com.register.login.exception;

import com.register.login.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginException {

    @ExceptionHandler(InvalidLoginPassword.class)
    public ResponseEntity<ErrorModel> handleInvalidLoginPassword(InvalidLoginPassword invalidLoginPassword) {
        ErrorModel errorModel = ErrorModel.builder().errorCode("Error-400").errorMessage(invalidLoginPassword.getMessage()).build();

        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidLoginEmail.class)
    public ResponseEntity<ErrorModel> handleInvalidLoginEmail(InvalidLoginEmail invalidLoginEmail) {
        ErrorModel errorModel = ErrorModel.builder().errorCode("Error-400").errorMessage(invalidLoginEmail.getMessage()).build();

        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}
