package com.company.project.restlet.hello;

import java.io.IOException;

import javax.ws.rs.Produces;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.company.project.model.system.User;
import com.company.project.service.system.prototype.IUserService;

@Service("/user/{id}/json")
@Scope("prototype")
public class JsonResource extends ServerResource{

	@Autowired
	private IUserService userService;
	
	@Get
	@Produces("application/json")
	public String represent(){
		
		String userID = (String)getRequestAttributes().get("id");
		
		User u = userService.getUser(Integer.valueOf(userID));
		System.out.println(u);
		
		ObjectMapper om = new ObjectMapper();
		
		String value = "";
		try {
			//-- 加入writeWithDefaultPrettyPrinter()方法仅仅是为了更加的格式化
			value = om.writerWithDefaultPrettyPrinter().writeValueAsString(u);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
}
