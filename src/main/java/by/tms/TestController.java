package by.tms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ModelAndView test(HttpSession httpSession, User user, ModelAndView modelAndView) {
        modelAndView.setViewName("test");
        httpSession.setAttribute("user", user);
        return modelAndView;
    }

    @GetMapping("/{value}")
    public String test2(@PathVariable("value") String value,
                        @RequestParam("price") Integer price,
                        Model model,
                        HttpSession httpSession) {
        model.addAttribute("value", value);
        model.addAttribute("price", price);
        return "test2";
    }

    @PostMapping
    public String post() {
        return "post";
    }
}
