package practice.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.entity.User;
import practice.service.UserService;

import java.util.List;

@Component
public class UserValidation {

    @Autowired
    UserService userService;

    public String checkDataForRegistration(String firstName, String lastName, String email, String password, String repassword) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            return "You don't input firstname or lastname";
        }
        if (!password.equals(repassword)) {
            return "You input incorrect password";
        }
        User user = userService.getUserByEmail(email);
        if (user.getEmail().equals(email)) {
            return "this login already exists";
        }
        return "";
    }

    public String checkDataToLogin(String email, String password) {
         User user = userService.getUserByEmail(email);
            if(user.getEmail().equals(email)){

            }
        return "";

    }

}
