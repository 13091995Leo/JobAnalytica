package com.mastek.jobapp.apis;

import java.util.Set;

import javax.print.attribute.standard.Media;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;
import com.mastek.jobapp.repository.UserRepository;

@Component
@Path("/users/")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RequirementService specialityService;
	
	@Autowired
	private JobService jobService;
	
	public UserService() {
		System.out.println("User Service Created");
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerOrUpdateUser(@BeanParam User user) {
		user = userRepository.save(user);
		System.out.println("User Registered " + user);
		return user;
	}

	@Path("/find/{userId}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User findByUserId(@PathParam("userId") int userId) {
		try {
			return userRepository.findById(userId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DELETE
	@Path("/delete/{userId}")
	public String deleteByUserId(@PathParam("userId") int userId) {
		try {
			userRepository.deleteById(userId);
			String statement = "User with User ID = " + userId + " sucessfully deleted";
			System.out.println(statement);
			return statement;
		} catch (Exception e) {
			e.printStackTrace();
			String statement = "User with user ID = " + userId + " does not exist";
            System.out.println(statement);
            return statement;
		}
	}
	
//	@Path("/findByName/{userId}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	public User findByName(@PathParam("userName") String userName) {
//		try {
//			return userRepository.findByUserName(userName).get();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	@Transactional
	@POST
	@Path("/assign/speciality")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Requirement> assignSpeciality(@FormParam("userId") int userId, @FormParam("specialityId") int specialityId) {
		try {
			User user = findByUserId(userId);
			Requirement spec = specialityService.findByRequirementId(specialityId);
			user.getUserSpeciality().add(spec);
			user = registerOrUpdateUser(user);
			return user.getUserSpeciality();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	@POST
	@Path("/remove/speciality")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Requirement> removeSpeciality(@FormParam("userId") int userId, @FormParam("specialityId") int specialityId) {
		try {
			User user = findByUserId(userId);
			Requirement spec = specialityService.findByRequirementId(specialityId);
			user.getUserSpeciality().remove(spec);
			user = registerOrUpdateUser(user);
			return user.getUserSpeciality();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/displayAllUsers")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Iterable<User> fetchAllUsers(){
		return userRepository.findAll();
	}
	
	
	

	
	
}
