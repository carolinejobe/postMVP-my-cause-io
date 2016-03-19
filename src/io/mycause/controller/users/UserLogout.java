package io.mycause.controller.users;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogout {

	@RequestMapping("/logout")
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response){

		try {
			Cookie[] clientCookies = request.getCookies();
			
			if (clientCookies[1] != null) {
				clientCookies[1].setMaxAge(0);
				response.addCookie(clientCookies[1]);
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
