package practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.service.UserService;
import practice.validation.UserValidation;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidation userValidation;

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration_page";
    }

    @PostMapping("/registration")
    public String registrationUser(@RequestParam("firstname") String firstName,
                                   @RequestParam("lastname") String lastName,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   @RequestParam("repassword") String repassword,Model model) {
        String checkUserData = userValidation.checkDataForRegistration(firstName, lastName, email, password, repassword);
        if (checkUserData.isEmpty()) {
            userService.saveUser(firstName,lastName,email,password);
            return "successful_registration";
        } else {
            model.addAttribute("error",checkUserData);
            return "error_page";
        }
    }
}
