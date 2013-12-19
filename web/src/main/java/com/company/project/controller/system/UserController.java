package com.company.project.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
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
		mv.setViewName("/user/list");
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
	public String getUsers(HttpServletRequest request){
		//-- 转换Objects Data 到 Json Data
		ObjectMapper om = new ObjectMapper();
		
		//-- 1. 从request对象中获取params JSON对象
		String paramsJSONStr = request.getParameter("params");
		//-- 2. 利用JSON工具把paramsJSONStr转换为paramsVO值对象
		User paramsVO = null;
		try {
			paramsVO = om.readValue(paramsJSONStr, User.class);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//-- 3. 查询参数条件传入业务方法，产生正确的结果
		PagerModel<User> pm = userService.findPaginated(paramsVO,User.class);
		
		//-- 4. 把结果数据转变为JSON串传输给页面
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
