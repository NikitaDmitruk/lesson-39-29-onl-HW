package by.tms.controllers;

import by.tms.model.User;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginGet(String username, Model model) {
        model.addAttribute("username", username);
        return "login";
    }

    @PostMapping
    public String loginPost(String username, String password, HttpSession session, Model model) {
        Optional<User> login = userService.login(username, password);
        if (login.isPresent()) {
            User user = login.get();
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User not found");
            return "login";
        }
    }
}
