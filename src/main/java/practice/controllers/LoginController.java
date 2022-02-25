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
public class LoginController {

    @Autowired
    private UserValidation userValidation;

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login_page";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password, Model model) {
        String checkData = userValidation.checkDataToLogin(email, password);
        if (!checkData.isEmpty()) {
            model.addAttribute("error", checkData);
            return "error_page";
        } else {
            String ID = userService.findIDByEmail(email);
            return "redirect:/" + ID;
        }
    }
}
