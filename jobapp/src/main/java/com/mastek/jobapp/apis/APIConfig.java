package com.mastek.jobapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

// Create the Jersey server configuration class
@Component
public class APIConfig extends ResourceConfig {
	
	public APIConfig() {
		//Register the CORS Settings on the server
		register(CORSFilter.class);
		// Register each service class in ResourceConfig
		register(CompanyService.class);
		register(UserService.class);
		register(JobsService.class);
	}

}
