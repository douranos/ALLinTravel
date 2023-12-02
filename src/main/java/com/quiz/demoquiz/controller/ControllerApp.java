package com.quiz.demoquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.service.QuestionService;

import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/quiz")
public class ControllerApp {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions/{id}")
    public String getQuestion(Model model, @PathVariable int id) {
        List<Quiz> allQuestions = questionService.getAllQuestions();
        if (id >= 0 && id < allQuestions.size()) {
            model.addAttribute("question", allQuestions.get(id));
            model.addAttribute("currentIndex", id);
            model.addAttribute("totalQuestions", allQuestions.size());
        }
        return "questions"; // Name of the Thymeleaf template
    }
}

