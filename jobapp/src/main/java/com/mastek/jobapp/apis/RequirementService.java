package com.mastek.jobapp.apis;

import java.util.List;
import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.jobapp.entities.Job;
import com.mastek.jobapp.entities.Requirement;
import com.mastek.jobapp.repository.JobRepository;
import com.mastek.jobapp.repository.RequirementRepository;

@Component
@Path("/requirements/")
public class RequirementService {
	
	@Autowired
	private RequirementRepository requirementRepository;

	public RequirementService() {
		System.out.println("Requirement Service Created");
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Requirement registerOrUpdateRequirement(@BeanParam Requirement requirement) {
		requirement = requirementRepository.save(requirement);
		System.out.println("Requirement Registered "+requirement);
		return requirement;
	}
		
	@Path("/find/{requirementId}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Requirement findByRequirementId(@PathParam("requirementId") int requirementId) {
		try {
			return requirementRepository.findById(requirementId).get();
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}
	}
		
	@DELETE
	@Path("/delete/{requirementId}")
		public String deleteRequirementById(@PathParam("requirementId") int requirementId) {
			 try {
	            requirementRepository.deleteById(requirementId);
	            String statement = "Requirement with requirement ID = " + requirementId + " sucessfully deleted";
	            System.out.println(statement);
		        return statement;
			 } catch (Exception e) {
	            e.printStackTrace();
	            String statement = "Requirement with requirement ID = " + requirementId + " does not exist";
	            System.out.println(statement);
	            return statement;
	        }
				
		}	
	
	@GET
	@Path("/displayAllRequirements")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Iterable<Requirement> fetchAllRequirements(){
		return requirementRepository.findAll();
	}
	
/*	@Path("/findJobs")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Set<Job> findJobsByRequirementId() {
		try {
			return requirement.getJobRequirement();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
}
