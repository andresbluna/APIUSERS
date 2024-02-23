package com.api.apirestuser.utils;
import org.springframework.stereotype.Component;
@Component
public class Validator {


    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)"
                + "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(EMAIL_REGEX);
    }
    private boolean isValidPasswordFormat(String password) {
        String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(PASSWORD_REGEX);
    }


}
