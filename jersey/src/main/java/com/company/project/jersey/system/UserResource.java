package com.company.project.jersey.system;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.project.model.system.User;
import com.company.project.service.system.prototype.IUserService;

@Component
@Path("/user")
public class UserResource {
	
	@Autowired
	private IUserService userService;
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public String getUser(@PathParam("id") int id){
		User u = userService.getUser(id);
		System.out.println(u);
		ObjectMapper om = new ObjectMapper();
		
		String userJsonData = "";
		try {
			//-- 加入writeWithDefaultPrettyPrinter()方法仅仅是为了更加的格式化
			userJsonData = om.writerWithDefaultPrettyPrinter().writeValueAsString(u);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userJsonData;
	}
}
