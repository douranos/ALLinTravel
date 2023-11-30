package com.example.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "");
        return "hello";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/questions")
    public String questions() {
        return "questions";
    }
}
