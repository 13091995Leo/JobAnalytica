package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.jobapp.apis.JobService;
import com.mastek.jobapp.apis.UserService;
import com.mastek.jobapp.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {
	
	
	@Autowired
	com.mastek.jobapp.entities.Job job;
	
	@Autowired
	JobService jobService;

	@Test
	public void exampleJobTest() {
		System.out.println("Job Test Created");
		Job job = new Job();
		job.SetJobTitle("Senior Developer");
		job.setRequirements("Java");
		job.setSalary("30000");
		job.setLocation("London");
		job.setCompanyId(0001);
		job = jobService.registerOrUpdateJob(job);
		assertNotNull(job);j
	
	}
	
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
