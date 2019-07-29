package com.mastek.jobapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="User")
@EntityListeners({UserLifeCycleListener.class})
public class User implements Serializable{
	
	@Value("-1")
	private int userId;
	
	@Value("Default User Name")
	private String userName;
	
	@Value("Default Location")
	private String locationPreference;
	
	@Value("Default Speciality")
	private String speciality;
	
	public User() {
		System.out.println("User Created");
	}
	
	// many to many relationship
	private Set<Job> group = new HashSet<>();
	
	@ManyToMany(mappedBy = "assignments", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Job> getGroup() {
		return group;
	}
	
	public void setGroup(Set<Job> group) {
		this.group = group;
	}
	

	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="locationPreference")
	public String getLocationPreference() {
		return locationPreference;
	}

	public void setLocationPreference(String locationPreference) {
		this.locationPreference = locationPreference;
	}

	@Column(name="speciality")
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
