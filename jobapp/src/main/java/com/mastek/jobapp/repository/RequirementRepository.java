package com.mastek.jobapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Requirement;

//@Component
public interface RequirementRepository extends CrudRepository<Requirement, Integer>{

}
