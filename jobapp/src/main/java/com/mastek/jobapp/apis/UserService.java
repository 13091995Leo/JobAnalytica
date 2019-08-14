package com.mastek.jobapp.apis;

import java.lang.ProcessBuilder.Redirect;
import java.util.Set;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.entities.User;
import com.mastek.jobapp.repository.JobRepository;
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
	
	private Requirement speciality;
	
	private User user;
	
	private Job job;
	
	public UserService() {
		System.out.println("User Service Created");
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerUser(@BeanParam User user) {
		user = userRepository.save(user);
		return user;		
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@BeanParam User user) {
		int userId = user.getUserId();
		User existingUser = findByUserId(userId);
		
		String userName = user.getUserName();
		String locationPreference = user.getLocationPreference();
		String userPassword = user.getUserPassword();
		
		if (userName != null) {
			existingUser.setUserName(userName);
		}		
		if (locationPreference != null) {
			existingUser.setLocationPreference(locationPreference);
		}
		if (userPassword != null) {
			existingUser.setUserPassword(userPassword);
		}		

		userRepository.save(existingUser);
		System.out.println("User Registered " + user);
		return existingUser;
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
	
	@Path("/findUserPassword/{userId}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String[] getUserPassword(@PathParam("userId") int userId) {
		try {
			user = findByUserId(userId);
			String[] password = {user.getUserPassword()};
			return password;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Path("/findUser")
	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Transactional
	public User findByUserIdAndPwd(@QueryParam("userId") int userId, @QueryParam("userPassword") String userPassword) {
		try {
			user = findByUserId(userId);
			String pwd = user.getUserPassword();
			if (userPassword.equals(pwd)) {
				return user;
			}
			else {
				System.out.println("Invalid login credentials");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@POST //HTTP method
	@Path("/deleteUserSpeciality") //URL
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	@Transactional
	public Set<Requirement> deleteUserSpeciality(@FormParam("userId") int userId, @FormParam("requirementId") int requirementId) {
        try {
        	user = findByUserId(userId);
            speciality = specialityService.findByRequirementId(requirementId);
           
            user.getUserSpeciality().remove(speciality);
           
            registerUser(user);
    
            return user.getUserSpeciality();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	@POST //HTTP method
	@Path("/deleteUserJob") //URL
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	@Transactional
	public Set<Job> deleteUserJob(@FormParam("userId") int userId, @FormParam("jobId") int jobId) {
        try {
        	user = findByUserId(userId);
        	job = jobService.findByJobId(jobId);
            user.getGroup().remove(job);
            userRepository.save(user);
    
            return user.getGroup();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@DELETE
	@Path("/delete/{userId}")
	public String deleteByUserId(@PathParam("userId") int userId) {
		try {
			user = findByUserId(userId);
			
			for(Job job:user.getGroup()) {
				jobService.removeJobsFromUser(userId, job.getJobId());
			}
			
			Set<Requirement> userSpecialities = user.getUserSpeciality();
			user.getUserSpeciality().removeAll(userSpecialities);
			
			registerUser(user);
						
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
	
	@Transactional
	@POST
	@Path("/assign/speciality")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User assignSpeciality(@FormParam("userId") int userId, @FormParam("specialityId") int specialityId) {
		try {
			user = findByUserId(userId);
			speciality = specialityService.findByRequirementId(specialityId);
			user.getUserSpeciality().add(speciality);
			//user = userRepository.save(user);
			return user;
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
			user = registerUser(user);
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
