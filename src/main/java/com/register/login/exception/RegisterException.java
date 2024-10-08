package com.register.login.exception;


import com.register.login.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegisterException {

    @ExceptionHandler(InvalidPasswordMatch.class)
    public ResponseEntity<ErrorModel> handlePasswordMatchException(InvalidPasswordMatch invalidPasswordMatch) {

        ErrorModel errorModel = ErrorModel.builder().errorCode("Error-400").errorMessage(invalidPasswordMatch.getMessage()).build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailExistsInDatabase.class)
    public ResponseEntity<ErrorModel> handleEmailExitsException(EmailExistsInDatabase emailExistsInDatabase) {

        ErrorModel errorModel = ErrorModel.builder().errorCode("Error-400").errorMessage(emailExistsInDatabase.getMessage()).build();

        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}
