package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowCause {
	
	@RequestMapping("/cause")
	public ModelAndView helloWorld()
	{
	return new
	ModelAndView("cause","message","Test Cause Message");
	}

}