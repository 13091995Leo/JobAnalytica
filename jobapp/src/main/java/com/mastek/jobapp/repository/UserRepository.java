package com.mastek.jobapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastek.jobapp.entities.User;

public interface UserRepository  extends CrudRepository<User, Integer> {

	@Autowired
	public List<User> findByUserName(@Param("userName") String userName);
	
}
