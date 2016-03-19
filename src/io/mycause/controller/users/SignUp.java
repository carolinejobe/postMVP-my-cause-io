package io.mycause.controller.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUp {
	
	@RequestMapping("/signup")
	public ModelAndView helloWorld()
	{
	return new
	ModelAndView("signup","message","Test Signup Message");
	}

}