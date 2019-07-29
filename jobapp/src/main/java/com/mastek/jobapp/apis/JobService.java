package com.mastek.jobapp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.repository.JobRepository;

@Component
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public JobService() {
		System.out.println("Job Service Created");
	}
	
	public Job registerOrUpdateJob(Job job) {
		job = jobRepository.save(job);
		System.out.println("Job Registered "+job);
		return job;
	}
		
	public void deleteByjobId(int jobId) {
			jobRepository.deleteById(jobId);	
		}	

}
