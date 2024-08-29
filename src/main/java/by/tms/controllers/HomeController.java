package by.tms.controllers;

import by.tms.model.Operation;
import by.tms.model.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String homeGet() {
        return "home";
    }

    @PostMapping
    public String homePost(Operation operation, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        operationService.execute(operation, user.getId());
        model.addAttribute("result", operation.getResult());
        return "home";
    }
}
