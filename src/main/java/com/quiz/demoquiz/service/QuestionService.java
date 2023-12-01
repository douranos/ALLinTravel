package com.quiz.demoquiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.demoquiz.Quiz;
import com.quiz.demoquiz.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Quiz> getAllQuestions() {
        return questionDao.findAll();
    }
}
