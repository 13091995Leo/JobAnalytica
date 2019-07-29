package com.mastek.jobapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.jobapp.apis.JobService;

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
		assertNotNull(job);
		
	
		
		/*System.out.println("Leo Test Merge ");
		System.out.println("Hello");
		System.out.println("Tim");
		System.out.println("I am Josh");
		System.out.println("World1");
		System.out.println("Matt");
		System.out.println("Matt can you read this");
		System.out.println("Hello Darkness my old friend");
		System.out.println("No");*/
	}

}
