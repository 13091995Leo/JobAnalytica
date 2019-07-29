package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	}
	
	@Test

	public void deleteJob() {
	int jobId = 1;
	jobService.deleteJobById(jobId);
	assertNull(jobService.findByJobId(jobId));
	}
	
	@Test
	public void findByJobIdUsingService() {
		int jobId =1;
		assertNotNull(jobService.findByJobId(jobId));
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	
/*	@Test
	public void addOrUpdateUserUsingService() {
		user.setUserId(0);
		user.setUserName("Test name");
		user.setLocationPreference("Test location");
		user.setSpeciality("Test speciality");
		user = userService.registerOrUpdateUser(user);
		assertNotNull(user);
	}
	
	@Test
	public void findByUserIdUsingService() {
		int userId = 4;
		assertNotNull(userService.findByUserId(userId));
	}
	
	@Test
	public void deleteByUserIdUsingService() {
		int userId = 2;
		userService.deleteByUserId(userId);
		assertNull(userService.findByUserId(userId));
	} */
	
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
	}
	
	
	@Test
	public void findByCompanyIdUsingService() {
		int companyId =3;
		assertNotNull(companyService.findByCompanyId(companyId));
	}


	
	@Test
	public void addJobsWithCompany() {
		Company comp1 = new Company();
		comp1.setCompanyName("Mastek");
		comp1.setLocation("Leeds");
		
		Job job1 = new Job();
		job1.setJobTitle("Dev Ops");
		job1.setRequirements("Python");
		
		Job job2 = new Job();
		job2.setJobTitle("Testing");
		job2.setRequirements("Java");
		
		comp1.getJobs().add(job1);
		comp1.getJobs().add(job2);
		
		job1.setCurrentCompany(comp1);
		job2.setCurrentCompany(comp1);
		
		companyService.registerOrUpdateCompany(comp1);
		}
	
}
