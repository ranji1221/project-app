package com.company.project.restlet.hello;

import javax.ws.rs.Produces;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.company.project.service.system.prototype.IUserService;

@Service("/hi")
@Scope("prototype")
public class HelloResource extends ServerResource{
	
	@Autowired
	private IUserService userService;
	
	@Get
	@Produces("text/plain")
	public String represent(){
		System.out.println(userService);
		return "hello, restlet!";
	}
}
