package com.mastek.jobapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastek.jobapp.entities.Job;

public interface JobRepository extends CrudRepository<Job, Integer> {

	public List<Job> findByJobId(@Param("jobId") String jobId);

}
