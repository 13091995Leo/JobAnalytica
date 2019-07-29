package com.mastek.jobapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mastek.jobapp.entities.User;

public interface UserRepository  extends CrudRepository<User, Integer> {

}
