package com.register.login.service;

import com.register.login.exception.InvalidLoginEmail;
import com.register.login.exception.InvalidLoginPassword;
import com.register.login.model.LoginRequest;
import com.register.login.model.User;
import com.register.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String userLogin(LoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            User userObject = user.get();
            String userName = userObject.getName();

            if (userObject.getPassword().equals(password)) {
                return userName + " login successfully";
            } else
                throw new InvalidLoginPassword("Invalid password! Please write a correct password");
        } else
            throw new InvalidLoginEmail("Email is not found in database.");
    }
}
