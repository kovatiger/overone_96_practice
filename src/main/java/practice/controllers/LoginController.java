package practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.validation.UserValidation;

@Controller
public class LoginController {

    @Autowired
    private UserValidation userValidation;

    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login_page";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password){
        userValidation.checkDataToLogin(email,password);
        return "successful_login";
    }

}
