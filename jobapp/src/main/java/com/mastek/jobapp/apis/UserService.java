package com.mastek.jobapp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.User;
import com.mastek.jobapp.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		System.out.println("User Service Created");
	}

	public User registerOrUpdateUser(User user) {
		user = userRepository.save(user);
		System.out.println("User Registered " + user);
		return user;
	}
	
	
	
}
