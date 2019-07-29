package com.mastek.jobapp.repository;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {

}
