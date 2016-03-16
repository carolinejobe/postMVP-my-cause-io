package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PromptForBrowse {
	
	@RequestMapping("/browse")
	public ModelAndView promptBrowse() {
		
		return new ModelAndView("browse", "message", "");
		
	}
}