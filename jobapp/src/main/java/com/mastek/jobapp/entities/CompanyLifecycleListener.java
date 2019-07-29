package com.mastek.jobapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class CompanyLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Company c) {
		System.out.println("Before Insert: " + c);
	}

	@PostPersist
	public void afterInsert(Company c) {
		System.out.println("After Insert: " + c);
	}
	
	@PreUpdate
	public void beforeUpdate(Company c) {
		System.out.println("Before Update: " + c);
	}
	
	@PostUpdate
	public void afterUpdate(Company c) {
		System.out.println("After Update: " + c);
	}
	
	@PreRemove
	public void beforeDelete(Company c) {
		System.out.println("Before Delete: " + c);
	}
	
	@PostLoad
	public void afterSelect(Company c) {
		System.out.println("After Select: " + c);
	}

}
