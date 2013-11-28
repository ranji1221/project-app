package com.company.project.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.company.project.model.system.User;
import com.company.project.service.system.prototype.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(User user){
		ModelAndView mv = new ModelAndView();
		if(userService.addUser(user))
			mv.addObject("message", "Add "+user.getUname()+" Success.");
		else
			mv.addObject("message", "userName '"+user.getUname()+"' is exists, please try another one?");
		return mv;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		List<User> users = userService.findAll();
		mv.setViewName("/user/list");
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		User user = userService.getUser(id);
		mv.addObject("user", user);
		mv.setViewName("/user/update");
		return mv;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(User user){
		ModelAndView mv = new ModelAndView();
		userService.updateUser(user);
		mv.setView(new RedirectView("list"));
		return mv;
	}
	
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public ModelAndView view(@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/view");
		User user = userService.getUser(id);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		userService.delete(id);
		mv.setView(new RedirectView("../list"));
		return mv;
	}
}
