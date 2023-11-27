package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

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

