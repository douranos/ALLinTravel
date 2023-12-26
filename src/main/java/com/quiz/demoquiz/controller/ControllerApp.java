/*package com.quiz.demoquiz.controller;

import com.quiz.demoquiz.Answer;
import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.dao.ChoiceDao;
import com.quiz.demoquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class ControllerApp {

    @Autowired
    QuestionService questionService;

    @Autowired
    ChoiceDao choiceDao; // Autowire the ChoiceDao

    @GetMapping("/questions/{id}")
    public String getQuestion(Model model, @PathVariable int id, HttpSession session) {
        List<Quiz> allQuestions = questionService.getAllQuestions();
        if (id >= 0 && id < allQuestions.size()) {
            Quiz currentQuestion = allQuestions.get(id);
            model.addAttribute("question", currentQuestion);
            model.addAttribute("currentIndex", id);
            model.addAttribute("totalQuestions", allQuestions.size());

            if (currentQuestion.isMultipleChoice()) {
                model.addAttribute("choices", questionService.getChoicesForQuestion(currentQuestion.getId()));
            }
        }
        // Load previous answers from session
        List<Answer> answers = (List<Answer>) session.getAttribute("answers");
        if (answers == null) {
            answers = new ArrayList<>();
            session.setAttribute("answers", answers);
        }

        model.addAttribute("answers", answers); // Send current answers to the view
        return "questions";
    }

    @PostMapping("/questions/{nextId}")
    public String submitAnswerAndGoNext(@PathVariable int nextId, @RequestParam(required = false) Integer selectedChoice, @RequestParam(required = false) String textInput, HttpSession session) {
        List<Answer> answers = (List<Answer>) session.getAttribute("answers");
        if (answers == null) {
            answers = new ArrayList<>();
        }
    
        Answer answer = new Answer();
        answer.setQuestionId(nextId);
    
        Quiz currentQuestion = questionService.getQuestionById(nextId); // Assuming you have such a method
        if (currentQuestion.isMultipleChoice() && selectedChoice != null) {
            String choiceText = questionService.getChoiceTextById(currentQuestion.getId(), selectedChoice);
            answer.setUserResponse(choiceText);
        } else if (textInput != null) {
            answer.setUserResponse(textInput);
        }
    
        answers.add(answer);
        session.setAttribute("answers", answers);
    
        if (nextId > 20) {
            return "redirect:/quiz/summary";
        } else {
            return "redirect:/quiz/questions/" + nextId;
        }
    }
    


    // Method to determine the next question ID or end of the quiz
    private int determineNextQuestionId(int currentId) {
        // Implement your logic here to determine the next question ID
        // For simplicity, this just increments the current ID
        return currentId;
    }

    @GetMapping("/summary")
    public String showSummary(Model model, HttpSession session) {
        List<Answer> answers = (List<Answer>) session.getAttribute("answers");
        if (answers != null) {
            model.addAttribute("answers", answers);
        }
        return "summary"; // summary.html Thymeleaf template
    }

}*/