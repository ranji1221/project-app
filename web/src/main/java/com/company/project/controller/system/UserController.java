package com.company.project.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.project.model.pager.PagerModel;
import com.company.project.model.system.User;
import com.company.project.service.system.prototype.IUserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/userui/list");
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(User user){
		String result="";
		try {
			userService.save(user, User.class);
			result = "{ \"success\":true}";
		} catch (Exception e) {
			result = "{ \"msg\":\"sorry, add failure!\"}";
		}
		return result;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(User user){
		String result="";
		try {
			userService.update(user, User.class);
			result = "{ \"success\":true}";
		} catch (Exception e) {
			result = "{ \"msg\":\"sorry, add failure!\"}";
		}
		return result;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public String delete(@PathVariable int id){
		String result="";
		try {
			userService.deleteByID(id, User.class);
			result = "{ \"success\":true}";
		} catch (Exception e) {
			result = "{ \"msg\":\"sorry, add failure!\"}";
		}
		return result;
	}
	
	
	
	@RequestMapping(value="/getusers",method=RequestMethod.POST)
	@ResponseBody
	public String getUsers(){
		PagerModel<User> pm = userService.findPaginated(User.class);
		
		//-- 转换Objects Data 到 Json Data
		ObjectMapper om = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("total", pm.getTotal());
		map.put("rows", pm.getData());
		
		String jsonData = "";
		try {
			jsonData = om.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}
}
