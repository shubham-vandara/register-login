package com.register.login.controller;

import com.register.login.model.User;
import com.register.login.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<User> userRegister(@RequestBody User user) {
        User userRes = registerServiceImpl.userRegister(user);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }

    @GetMapping("/getObject")
    public User User() {
        return User.builder().build();
    }
}
