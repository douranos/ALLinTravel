package com.quiz.demoquiz;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Table;

import java.util.List;  

@Entity
@Table(name = "travel_questions")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String question;

    // Getter and setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and setter for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "IsMultipleChoice")
    private boolean isMultipleChoice;

    @OneToMany(mappedBy = "quiz")
    private List<Choice> choices = new ArrayList<>();

    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }
}



