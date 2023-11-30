package com.example.helloworld.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.helloworld.model.User;
import com.example.helloworld.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}