package by.tms.controllers;

import by.tms.model.Operation;
import by.tms.model.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/history")


public class HistoryController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public ModelAndView history(HttpSession session, ModelAndView modelAndView) {
        modelAndView.setViewName("history");
        User user = (User) session.getAttribute("user");
        List<Operation> operations = operationService.findAll(user.getId());
        modelAndView.addObject("operations", operations);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
