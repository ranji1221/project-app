package com.company.project.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/easyui")
public class EasyUIController {
	
	@RequestMapping(value="/demo01",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/ui/demo01");
		return mv;
	}
}
