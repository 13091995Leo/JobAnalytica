package com.mastek.jobapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="USER")
public class User {
	
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="locationPreference")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getLocationPreference() {
		return locationPreference;
	}

	public void setLocationPreference(String locationPreference) {
		this.locationPreference = locationPreference;
	}

	@Column(name="speciality")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
