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
import com.mastek.jobapp.entities.JobRole;
import com.mastek.jobapp.entities.JobSkillRole;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {
	
/*	@Autowired
	Job job;	
	
	@Autowired
	JobService jobService;

	@Test
	public void addOrUpdateJobUsingService() {
		job.setJobTitle(JobRole.FullStackDeveloper);
		job.setSalary(10.00);
		job.setLocation("Test Location");
		job = jobService.registerOrUpdateJob(job);
		assertNotNull(job);
	}


	@Test
	public void deleteJobUsingService() {
	int jobId = 2;
	jobService.deleteJobById(jobId);
	assertNull(jobService.findByJobId(jobId));
	}

	@Test
	public void findByJobIdUsingService() {
		int jobId = 4;
		assertNotNull(jobService.findByJobId(jobId));
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	
	@Test
	public void addOrUpdateUserUsingService() {
		user.setUserName("Test name");
		user.setLocationPreference("Test location");
		user.setSpeciality(JobSkillRole.AWS);
		user = userService.registerOrUpdateUser(user);
		assertNotNull(user);
	}
	
	@Test
	public void findByUserIdUsingService() {
		int userId = 1;
		assertNotNull(userService.findByUserId(userId));
	}
	
	@Test
	public void deleteByUserIdUsingService() {
		int userId = 2;
		userService.deleteByUserId(userId);
		assertNull(userService.findByUserId(userId));
	}

	@Autowired
	CompanyService companyService;
	
	@Autowired
	Company company;
	
	@Test
	public void addOrUpdateCompanyUsingService() {	
		company.setCompanyName("Default company name");
		company.setIndustry("Default industry");
		company.setLocation("Default location");
		company = companyService.registerOrUpdateCompany(company);
		assertNotNull(company);
	}
	
	
	@Test
	public void findByCompanyIdUsingService() {
		int companyId = 1;
		assertNotNull(companyService.findByCompanyId(companyId));
	}
	
	@Test
	public void deleteCompany() {
		int companyId = 11;
		companyService.deleteCompanyById(companyId);
		assertNull(companyService.findByCompanyId(companyId));
		}


	
	@Test
	public void addJobsWithCompanyAndJobsForUsers() {
		Company comp1 = new Company();
		comp1.setCompanyName("Mastek");
		comp1.setLocation("Leeds");
		
		Job job1 = new Job();
		job1.setJobTitle(JobRole.DatabaseManager);
		
		Job job2 = new Job();
		job2.setJobTitle(JobRole.DevOpsEngineer);
		
		User user1 = new User();
		user1.setUserName("James");
		user1.setSpeciality(JobSkillRole.AWS);
		user1.setLocationPreference("Leeds");
		
		User user2 = new User();
		user2.setUserName("John");
		user2.setSpeciality(JobSkillRole.MongoDB);
		user2.setLocationPreference("Manchester");
		
		Requirement req1 = new Requirement();
		req1.setRequirement(JobSkillRole.CSS);
		
		Requirement req2 = new Requirement();
		req2.setRequirement(JobSkillRole.MongoDB);
		
		// Many to One - jobs to company
		comp1.getJobs().add(job1);
		comp1.getJobs().add(job2);
		
		// One To Many - company to jobs
		job1.setCurrentCompany(comp1);
		job2.setCurrentCompany(comp1);
		
		// Many To many - users to jobs
		job1.getAssignments().add(user1);
		job1.getAssignments().add(user2);
		job2.getAssignments().add(user2);
		
		// Many To many - users to jobs
		job1.getRequirements().add(req1);
		job1.getRequirements().add(req2);
		
		companyService.registerOrUpdateCompany(comp1);
		}
	*/
}
