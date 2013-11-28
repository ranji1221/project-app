package com.company.project.jersey.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/demo")
public class HelloResource {
	
	@GET
	@Path("/hello")
	public String sayHello(){
		return "hello jersey.";
	}
}
