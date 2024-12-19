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

    public boolean isValidPassword(String password) {
        // Regular expression to enforce password complexity rules:
        // - At least 8 characters (you can increase this length if needed)
        // - At least one uppercase letter
        // - At least one lowercase letter
        // - At least one digit
        // - At least one special character (e.g., @, #, $, %, etc.)

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        // Explanation:
        // ^               : Start of the string
        // (?=.*[a-z])     : At least one lowercase letter
        // (?=.*[A-Z])     : At least one uppercase letter
        // (?=.*\\d)       : At least one digit
        // (?=.*[@#$%^&+=!]): At least one special character (adjust the list as needed)
        // (?=\\S+$)       : No whitespace allowed
        // .{8,}           : Minimum 8 characters long
        // $               : End of the string

        return password.matches(regex);
    }


}
