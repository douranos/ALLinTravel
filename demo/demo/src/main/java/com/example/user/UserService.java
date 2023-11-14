package com.example.user;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    	public List<User> getUsers() {
		return List.of(
                    new User(
                        1L, 
                        "Chris", 
                        19, 
                        "smirnioschris@gmail.com"
                    ) 
                );
	}
}
