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

	public User findByUserId(int userId) {
		try {
			return userRepository.findById(userId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteByUserId(int userId) {
		try {
			userRepository.deleteById(userId);
			String statement = "User with User ID = " + userId + " sucessfully deleted";
			System.out.println(statement);
		} catch (Exception e) {
			e.printStackTrace();
			String statement = "ERROR";
			System.out.println(statement);
		}
	}
	
	
	
}
