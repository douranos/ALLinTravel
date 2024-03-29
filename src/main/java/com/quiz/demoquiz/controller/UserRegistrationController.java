package com.quiz.demoquiz.controller;
import com.quiz.demoquiz.service.UserService;
import com.quiz.demoquiz.controller.dto.UserRegistrationDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/signup")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {

        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/signup?success";
    }
}





