package com.example.helloworld.service;

import com.example.helloworld.model.User;
import com.example.helloworld.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
