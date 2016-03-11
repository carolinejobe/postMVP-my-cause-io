package io.mycause.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogin {
	
	@RequestMapping("/loginSuccess")
	public ModelAndView helloWorld(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		try {
			
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection(); 
			
			
			Statement s = conn.createStatement();
			ResultSet results = s.executeQuery("select * from user where email='"+email+"' and password='"+password+"'"); // this line selects
			
			if ( results.next())
			//set cookie
				
				
				
			return new ModelAndView("loginSuccess", "message", "yo");
			
			else
				new ModelAndView("loginSuccess","message","Test Login Message");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ModelAndView("error", "errorMessage", e.getMessage());
		}
	return new
	ModelAndView("login","message","Test Login Message");
	}

}
