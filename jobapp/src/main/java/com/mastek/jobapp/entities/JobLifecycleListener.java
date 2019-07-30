package com.mastek.jobapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class JobLifecycleListener {

	@PrePersist
	public void beforeInsert(Job j) {
		System.out.println("Before Insert: " + j);
	}

	@PostPersist
	public void afterInsert(Job j) {
		System.out.println("After Insert: " + j);
	}
	
	@PreUpdate
	public void beforeUpdate(Job j) {
		System.out.println("Before Update: " + j);
	}
	
	@PostUpdate
	public void afterUpdate(Job j) {
		System.out.println("After Update: " + j);
	}
	
	@PreRemove
	public void beforeDelete(Job j) {
		System.out.println("Before Delete: " + j);
	}
	
	@PostLoad
	public void afterSelect(Job j) {
		System.out.println("After Select: " + j);
	}

}

//Archive this as data, on a JSON data
