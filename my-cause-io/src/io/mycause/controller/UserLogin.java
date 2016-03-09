package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogin {
	
	@RequestMapping("/login")
	public ModelAndView helloWorld()
	{
	return new
	ModelAndView("login","message","Test Login Message");
	}

}
