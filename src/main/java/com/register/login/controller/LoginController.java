package com.register.login.controller;

import com.register.login.model.LoginRequest;
import com.register.login.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequest loginRequest) {
        String response = loginServiceImpl.userLogin(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
