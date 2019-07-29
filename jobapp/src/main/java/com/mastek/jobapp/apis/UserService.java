package com.mastek.jobapp.apis;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastek.jobapp.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		System.out.println("User Service Created");
	}
}
