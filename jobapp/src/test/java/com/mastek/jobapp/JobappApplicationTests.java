package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

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
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {

/*

	@Autowired
	Job job;	
	
	@Autowired
	JobService jobService;
	

	@Test
	public void addOrUpdateJobUsingService() {
		job.setJobTitle("Full Stack Developer");
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
		user.setSpeciality("AWS");
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
		job1.setJobTitle("Database Manager");
		
		Job job2 = new Job();
		job2.setJobTitle("Dev Ops Engineer");
		
		User user1 = new User();
		user1.setUserName("James");
		user1.setSpeciality("AWS");
		user1.setLocationPreference("Leeds");
		
		User user2 = new User();
		user2.setUserName("John");
		user2.setSpeciality("MongoDB");
		user2.setLocationPreference("Manchester");
		
		Requirement req1 = new Requirement();
		req1.setRequirement("CSS");
		
		Requirement req2 = new Requirement();
		req2.setRequirement("MongoDB");
		
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

		
		@Test
		public void checkFetchJobBySearchParam() {
		String searchParam = "Dev Ops";
		List<Job> job = jobService.fetchJobUsingSearchBar(searchParam);
		for (Job job2 : job) {
			System.out.println(job2);
		}
		}
*/
	
/*	@Autowired
	CompanyService companyService;
	
	@Autowired
	Company company;
	
	@Test
    public void addThousandDataEntries() {
		String firstNameArr[] = {"Matt ","Tom ","John ","Hollie ","Rosie ","Joe ","Fran ","Fred ","Freya ","Sam "};
		String middleNameArr[] = {"Mika ","Bailey ","Jules ","Alex ","Kyle ","River ","Harper ","Charlie ","Drew ","Logan"};
		String lastNameArr[] = {"Jeffries","Humpfries","Jones","Williams","Jameson","Reed","Brown","Stark","King","Smithers"};
        String compArr[] = {"Oscorp","WGG Solutions","Mastek","Atkins","GCS","Datasys","Softerim ltd.","Acure Rilan", "Gregory Inc.", "WGT Org."};
        String locArr[] = {"Leeds","Bradford","Manchester","London","Birmingham","Oxford","Cardiff","Hull","Essex","Cornwall"};
        String reqSpecArr[] = {"Java ","JavaScript","Dev Ops","Python","MySQL","PHP","HTML","MongoDB","Angular","CSS"};
        String jobTitleArr[] = {"Java Developer","JavaScript Developer","Senior Dev Ops Specialist","Python Developer","MySQL Specialist","Senior PHP Developer",
                "HTML Developer","MongoDB Specialist","Angular Specialist","CSS Assisstant"};
        String industryArr[] = {"Defence","IT","Energy","Public Sector","Chemical","Mining","Healthcare","Retail","Social Media","Confectionary"};
        

        for (int t = 1; t<11; t++) {
 
	        for (int i = 0; i < 100; i++) {
	        	
	            int v = (int) Math.floor(10*Math.random());
	            int j = (int) Math.floor(10*Math.random());
	            int k = (int) Math.floor(10*Math.random());
	            int x = (int) Math.floor(10*Math.random());
	            int y = (int) Math.floor(10*Math.random());
	            int z = (int) Math.floor(10*Math.random());
		        
	            Company comp = new Company();
		        comp.setCompanyName(compArr[t-1]);
		        comp.setLocation(locArr[t-1]);
		        comp.setCompanyPassword("******");
		        comp.setIndustry(industryArr[t-1]);
	        	comp.setCompanyId(t);
		           
		        Job job1 = new Job();
	            job1.setJobTitle(jobTitleArr[j]);
	            job1.setLocation(locArr[j]);
	            job1.setSalary(j*10000);
		           
	            Job job2 = new Job();
	            job2.setJobTitle(jobTitleArr[k]);
	            job2.setLocation(locArr[k]);
	            job2.setSalary(k*10000);
		  
	            User user1 = new User();
	            user1.setUserName(firstNameArr[v]+middleNameArr[j]+lastNameArr[k]);
	            user1.setLocationPreference(locArr[v]);
	            user1.setUserPassword("******");
		           
	            User user2 = new User();
	            user2.setUserName(firstNameArr[x]+middleNameArr[y]+lastNameArr[z]);
	            user2.setLocationPreference(locArr[j]);
	            user2.setUserPassword("******");
	           
	            Requirement req1 = new Requirement();
	            req1.setRequirement(reqSpecArr[v]);
	           
	            Requirement req2 = new Requirement();
	            req2.setRequirement(reqSpecArr[j]);
	            
	            Requirement req3 = new Requirement();
	            req3.setRequirement(reqSpecArr[k]);
	            
	            // One To Many - company to jobs
	            job1.setCurrentCompany(comp);
	            job2.setCurrentCompany(comp);
	           
	            // Many to One - jobs to company
	            comp.getJobs().add(job1);
	            comp.getJobs().add(job2);

	           
	            // Many To many - users to jobs
	            job1.getAssignments().add(user1);
	            job2.getAssignments().add(user2);
	           
	            // Many To many - jobs to requirements
	            job1.getRequirements().add(req1);
	            job1.getRequirements().add(req2);
	            
	            // Many To many - users to specialities
	            user1.getUserSpeciality().add(req1);
	            user2.getUserSpeciality().add(req2);
	            
	            companyService.registerOrUpdateCompany(comp);
	        }

        }
	}*/
	
}


