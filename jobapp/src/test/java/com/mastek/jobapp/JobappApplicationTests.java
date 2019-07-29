package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.jobapp.apis.UserService;
import com.mastek.jobapp.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {

	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	
	@Test
	public void addOrUpdateUserUsingService() {
		user.setUserId(0);
		user.setUserName("Test name");
		user.setLocationPreference("Test location");
		user.setSpeciality("Test speciality");
		user = userService.registerOrUpdateUser(user);
		assertNotNull(user);
	}

}
