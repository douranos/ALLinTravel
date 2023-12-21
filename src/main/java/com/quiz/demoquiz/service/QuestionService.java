package com.quiz.demoquiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.demoquiz.Choice;
import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.dao.ChoiceDao;
import com.quiz.demoquiz.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private ChoiceDao choiceDao;

    public List<Quiz> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Choice> getChoicesForQuestion(Integer questionId) {
        return choiceDao.findByQuizId(questionId);
    }

    public Quiz getQuestionById(Integer questionId) {
        return questionDao.findById(questionId).orElse(null);
    }

    public String getChoiceTextById(int questionId, int choiceId) {
        return choiceDao.findById(choiceId)
                        .map(Choice::getChoice)
                        .orElse(null); // return null or some default value if not found
    }
    
    
}

