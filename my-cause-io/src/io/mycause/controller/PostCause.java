package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostCause {
	
	@RequestMapping("/postcause")
	public ModelAndView helloWorld()
	{
	return new
	ModelAndView("postcause","message","Test Post Message");
	}

}