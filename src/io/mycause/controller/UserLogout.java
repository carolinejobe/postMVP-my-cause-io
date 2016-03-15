package io.mycause.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogout {

	@RequestMapping("/logout")
	public ModelAndView userLogout(HttpServletRequest request){

		try {
			Cookie[] clientCookies = request.getCookies();
			
			if (clientCookies[1] != null) {
				clientCookies[1].setMaxAge(0);
				clientCookies[0].setMaxAge(0);
				System.out.println(clientCookies[1].getMaxAge() + " "+ clientCookies[1].getName() + clientCookies[0].getMaxAge() + " "+ clientCookies[0].getName());
				return new ModelAndView("login", "message", "You have successfully logged out");
			}
			else{
				return new ModelAndView("login", "message", "You are not logged in.");
			}

		} 
			
			catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			return new ModelAndView("error", "message", "There was an issue logging out.");

		}
	}
}
