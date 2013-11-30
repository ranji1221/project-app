package com.company.project.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/backend")
public class AdminController {
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView toAdminPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/index/index");
		return mv;
	}
}
