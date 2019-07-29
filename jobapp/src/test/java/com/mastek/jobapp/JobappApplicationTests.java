package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.jobapp.apis.CompanyService;
import com.mastek.jobapp.apis.JobService;
import com.mastek.jobapp.apis.UserService;
import com.mastek.jobapp.entities.Company;
import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {
	
	@Autowired
	Job job;	
	
	@Autowired
	JobService jobService;

	@Test
	public void addOrUpdateJobUsingService() {
		job.setJobId(0);
		job.setJobTitle("Test Title");
		job.setRequirements("Test requirement");
		job.setSalary(10.00);
		job.setLocation("Test Location");
		job = jobService.registerOrUpdateJob(job);
		assertNotNull(job);
		System.out.println("Hello Leo can you hear me");
	
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
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	Company company;
	
	@Test
	public void addOrUpdateCompanyUsingService() {
		company.setCompanyId(0);
		company.setCompanyName("Default company name");
		company.setIndustry("Default industry");
		company.setLocation("Default location");
		company = companyService.registerOrUpdateCompany(company);
		assertNotNull(company);
		System.out.println("Hello from Leo");
	}

}
