package com.register.login.service;


import com.register.login.exception.EmailExistsInDatabase;
import com.register.login.exception.InvalidPasswordMatch;
import com.register.login.model.User;
import com.register.login.repository.UserRepository;
import com.register.login.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterValidator registerValidator;

    @Override
    public User userRegister(User user) {

        if (registerValidator.isValidPassword(user.getPassword())) {
            if (registerValidator.isPasswordMatch(user)) {
                return getUser(user);
            } else {
                throw new InvalidPasswordMatch("The password and confirm password do not match. Please ensure both fields contain the same password.");
            }
        } else {
            throw new InvalidPasswordMatch("Password does not meet the required criteria. It must be at least 8 characters long and include uppercase, lowercase, digit, and special character.");
        }


    }

    private User getUser(User user) {
        if (!isEmailPresent(user.getEmail())) {
            return userRepository.save(user);
        } else {
            throw new EmailExistsInDatabase("Email is already in exist in database. Please try with different email");
        }
    }

    private boolean isEmailPresent(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();  // Returns true if email exists, false otherwise
    }
}
