package practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.entity.User;
import practice.service.UserService;

@Controller
public class SuccessLogin {

    @Autowired
    private UserService userService;

    @GetMapping("/{ID}")
    public String loginSuccess(@PathVariable String ID, Model model) {
        User user = userService.findUserByID(ID);
        model.addAttribute("firstname",user.getFirstName());
        model.addAttribute("lastname",user.getLastName());
        model.addAttribute("email",user.getEmail());
        return "successful_login_page";
    }
}
