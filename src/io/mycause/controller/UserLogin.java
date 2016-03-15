package io.mycause.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogin {

	@RequestMapping("/processlogin")
	public ModelAndView helloWorld(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletResponse response) throws SQLException, NamingException {
		

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			Statement s = conn.createStatement();
			ResultSet results = s.executeQuery(
					"select user_id from maindb.users where email='" + email + "' and password='" + password + "'"); // this
																														// line
																														// selects

			if (results.next())

			{
				String userid = results.getString(1);
				Cookie c = new Cookie("userid", userid);

				response.addCookie(c);

				return new ModelAndView("index", "WelcomeMessage", "You have successfully logged in!");
			} else
			{
				return new ModelAndView("login", "message", "Looks like we had some trouble signing you in. Please try again.");

			}
		
		
		
	}
	
	}


