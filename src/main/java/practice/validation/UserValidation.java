package practice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.entity.User;
import practice.service.UserService;

@Component
public class UserValidation {

    @Autowired
    UserService userService;

    public String checkDataForRegistration(String firstName, String lastName, String email, String password, String repassword) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            return "You don't input something";
        }
        if (!password.equals(repassword)) {
            return "You input incorrect password";
        }
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return "this login already exists";
        }
        return "";
    }

    public String checkDataToLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return "you didn't input password or login";
        }
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return "this email doesn't exist";
        } else if (!user.getPassword().equals(password)) {
            return "your password isn't correct";
        }
        return "";
    }
}
