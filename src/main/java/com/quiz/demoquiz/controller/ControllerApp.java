package com.quiz.demoquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class ControllerApp {
    @Autowired
    QuestionService questionService;
    @GetMapping("questions")
    public List<Quiz> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    
}
