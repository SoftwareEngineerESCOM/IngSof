package com.san.greetings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class GreetingController {
    
    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("greeting1", "Good morning");
        model.addAttribute("greeting2", "Good Afternoon");
        model.addAttribute("greeting3", "Good Evening");
        model.addAttribute("greeting4", "Hello, how are you?");
        return "greeting/index";
    }
}
