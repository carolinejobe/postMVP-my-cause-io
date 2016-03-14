package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Controller
public class PostCause {

	@RequestMapping("/postcause")
	public String populateCatMenu(HttpServletRequest request) {
			Cookie[] clientCookies = request.getCookies();

			if (clientCookies == null || clientCookies.length == 1) {
				return "login";
			}
			return "postcause";
	}

}