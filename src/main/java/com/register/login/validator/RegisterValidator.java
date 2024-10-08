package com.register.login.validator;

import com.register.login.model.User;
import org.springframework.stereotype.Component;

@Component
public class RegisterValidator {

    public boolean isPasswordMatch(User user) {
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();
        return password.equals(confirmPassword);
    }

}
