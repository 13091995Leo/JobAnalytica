package com.mastek.jobapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class UserLifeCycleListener {
	public class CompanyLifecycleListener {
		
		@PrePersist
		public void beforeInsert(User u) {
			System.out.println("Before Insert: " + u);
		}

		@PostPersist
		public void afterInsert(User u) {
			System.out.println("After Insert: " + u);
		}
		
		@PreUpdate
		public void beforeUpdate(User u) {
			System.out.println("Before Update: " + u);
		}
		
		@PostUpdate
		public void afterUpdate(User u) {
			System.out.println("After Update: " + u);
		}
		
		@PreRemove
		public void beforeDelete(User u) {
			System.out.println("Before Delete: " + u);
		}
		
		@PostLoad
		public void afterSelect(User u) {
			System.out.println("After Select: " + u);
		}

	}

}
