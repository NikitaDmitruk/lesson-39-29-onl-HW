package by.tms.controllers;

import by.tms.model.User;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reg")
public class RegistrationController {
    @Autowired
    private  UserService userService;

    @GetMapping
    public String regGet() {
        return "reg";
    }

    @PostMapping
    public String regPost(User user) {
        userService.registration(user);
        return "redirect:/login?username="+user.getUsername();
    }
}
