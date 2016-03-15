package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PostCause {

	@RequestMapping("/postcause")
	public ModelAndView populateCatMenu(HttpServletRequest request) {
		Cookie[] clientCookies = request.getCookies();
		

		// if user is not logged in, bounce to login page with a message
		if (clientCookies == null || clientCookies.length == 1) {
			return new ModelAndView("login", "message", "You must be logged in to create a post.");
		}
		
		// if user is logged in, they will be able to submit a post
		else {
			return new ModelAndView("postcause", "message", "");
		}
	}

}