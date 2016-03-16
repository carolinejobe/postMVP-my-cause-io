package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PromptSearch {
	
	@RequestMapping("/search")
	public ModelAndView helloWorld()
	{
	return new
	ModelAndView("search","message","Test Search Message");
	}

}