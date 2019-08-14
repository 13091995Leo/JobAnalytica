package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.jobapp.apis.CompanyService;
import com.mastek.jobapp.apis.JobService;
import com.mastek.jobapp.apis.RequirementService;
import com.mastek.jobapp.apis.UserService;
import com.mastek.jobapp.entities.Company;
import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;
import com.mysql.cj.x.protobuf.MysqlxCrud.FindOrBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {


	@Autowired
	Job job;	
	
	@Autowired
	JobService jobService;
	
	@Autowired
	Requirement requirement;
	
	@Autowired
	RequirementService requirementService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	Company company;
	
	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	


/*	@Test
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
	}*/
	

/*	// Adds company and requirement entries to the DB - entities only, not the relationships
	@Test
    public void addCompaniesAndRequirements() {
		
    String reqSpecArr[] = {"Java ","JavaScript","Dev Ops","Python","MySQL","PHP","HTML","MongoDB","Angular","CSS"};
    String compArr[] = {"Oscorp","WGG Solutions","Mastek","Atkins","GCS","Datasys","Softerim ltd.","Acure Rilan", "Gregory Inc.", "WGT Org."};
    String industryArr[] = {"Defence","IT","Energy","Public Sector","Chemical","Mining","Healthcare","Retail","Social Media","Confectionary"};
    String locArr[] = {"Leeds","Bradford","Manchester","London","Birmingham","Oxford","Cardiff","Hull","Essex","Cornwall"};
		
    for (int i = 0; i<10; i++) {
    
        company.setCompanyName(compArr[i]);
        company.setLocation(locArr[i]);
        company.setCompanyPassword("******");
        company.setIndustry(industryArr[i]);
    	
        companyService.registerOrUpdateCompany(company);
    }
        
    for (int i = 0; i<10; i++) {
        
	    requirement.setRequirement(reqSpecArr[i]);
	    
	    requirementService.registerOrUpdateRequirement(requirement);
    }
	}
	
	// Adds user entries to user entity. Adds all relationships apart from those linking job to requirement
	@Test
    public void addThousandDataEntries() {
		String firstNameArr[] = {"Matt ","Tom ","John ","Hollie ","Rosie ","Joe ","Fran ","Fred ","Freya ","Sam "};
		String middleNameArr[] = {"Mika ","Bailey ","Jules ","Alex ","Kyle ","River ","Harper ","Charlie ","Drew ","Logan "};
		String lastNameArr[] = {"Jeffries","Humpfries","Jones","Williams","Jameson","Reed","Brown","Stark","King","Smithers"};
        String locArr[] = {"Leeds","Bradford","Manchester","London","Birmingham","Oxford","Cardiff","Hull","Essex","Cornwall"};
        String jobTitleArr[] = {"Java Developer","JavaScript Developer","Senior Dev Ops Specialist","Python Developer","MySQL Specialist","Senior PHP Developer",
                "HTML Developer","MongoDB Specialist","Angular Specialist","CSS Assisstant",};
 
	    for (int i = 0; i < 1000; i++) {
	        	
	        int v = (int) Math.floor(10*Math.random());
	        int j = (int) Math.floor(10*Math.random());
	        int k = (int) Math.floor(10*Math.random());
	        int x = (int) Math.floor(10*Math.random());
	        int y = (int) Math.floor(10*Math.random());
	        int z = (int) Math.floor(10*Math.random());
		    
	        System.out.println(x + " " + y);
	        
	        Job job1 = new Job();
	        job1.setJobTitle(jobTitleArr[j]);
	        job1.setLocation(locArr[j]);
	        job1.setSalary((k+1.35)*10000);
	           
	        Job job2 = new Job();
	        job2.setJobTitle(jobTitleArr[k]);
	        job2.setLocation(locArr[k]);
	        job2.setSalary((v+1.15)*10000);
		  
	        User user1 = new User();
	        user1.setUserName(firstNameArr[v]+middleNameArr[j]+lastNameArr[k]);
	        user1.setLocationPreference(locArr[v]);
	        user1.setUserPassword("******");
			           
	        User user2 = new User();
	        user2.setUserName(firstNameArr[x]+middleNameArr[y]+lastNameArr[z]);
	        user2.setLocationPreference(locArr[j]);
	        user2.setUserPassword("******");
		    
	        Requirement req1 = requirementService.findByRequirementId(x+11);
	        Requirement req2;
	        if (x == y && x<9) {
	        	req2 = requirementService.findByRequirementId(y+12);
	        }
	        else if (x == y && x==9) {
		        req2 = requirementService.findByRequirementId(y+10);
	        }
	        else {
	        	req2 = requirementService.findByRequirementId(y+11);
	        }
	       
		    Company comp = companyService.findByCompanyId(v+1);
	            
	        // Many to One - jobs to company
	        comp.getJobs().add(job1);
	        comp.getJobs().add(job2);
		           
	        // One To Many - company to jobs
	        job1.setCurrentCompany(comp);
	        job2.setCurrentCompany(comp);
	           
	        // Many To many - users to jobs
	        job1.getAssignments().add(user1);
	        job1.getAssignments().add(user2);
	        job2.getAssignments().add(user2);
		          
	        // Many To many - users to specialities
	        user1.getUserSpeciality().add(req1);
	        user1.getUserSpeciality().add(req2);
	        
	        companyService.registerOrUpdateCompany(comp);       	        
        }
	}
	
	
	// Adds requirements to jobs using an automated loop
	@Test
	public void addJobRequirements () {
		Iterable<Job> jobs = jobService.fetchAllJobs();
		int x;
		for (Job job : jobs) {
			x = (int) Math.floor(Math.random()*10);
	        job.getRequirements().add(requirementService.findByRequirementId(x+11));
			jobService.registerOrUpdateJob(job);
		}
	}*/
	
	
	
}
