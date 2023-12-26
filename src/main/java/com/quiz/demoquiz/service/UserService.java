package com.quiz.demoquiz.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.quiz.demoquiz.model.User;
import com.quiz.demoquiz.controller.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}