package com.mastek.jobapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastek.jobapp.entities.Job;

public interface JobRepository extends CrudRepository<Job, Integer> {


}
