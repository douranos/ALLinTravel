package com.quiz.demoquiz.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.demoquiz.Choice;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChoiceDao extends JpaRepository<Choice, Integer> {
    List<Choice> findByQuizId(Integer quizId);
    Optional<Choice> findById(Integer id);
}

