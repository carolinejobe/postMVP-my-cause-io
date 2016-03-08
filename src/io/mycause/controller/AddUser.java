package io.mycause.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddUser {

		@RequestMapping("/signup")
		public ModelAndView addUser(@RequestParam("groupName") String groupName, @RequestParam("email") String email) {
			try {
				//create connection to mySQL database
				Class.forName("com.mysql.jdbc.Driver");
				Connection c;
				String connectionString = "jdbc:mysql://localhost:3306/sakila";
				c = DriverManager.getConnection(connectionString, "root", "admin");
				
				//create mySQL insert statement
				String insertStatement = "INSERT INTO 'sakila'.'actor'('first_name','last_name')VALUES(?,?)";
				
				// create the mySQL insert preparedstatement
				PreparedStatement insertPreparedStatement = c.prepareStatement(insertStatement);
				insertPreparedStatement.setString(1, groupName);
				insertPreparedStatement.setString(2, email);
				
				// execute the preparedstatement
				insertPreparedStatement.execute();
				
						
				return new ModelAndView("testShowUser", "newUser", insertPreparedStatement);
				
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", e.getMessage());
			}
		}		
}
