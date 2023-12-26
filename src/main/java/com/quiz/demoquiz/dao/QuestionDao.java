package com.quiz.demoquiz.dao;
import com.quiz.demoquiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Quiz,Integer> {

    
}
