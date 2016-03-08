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
	public String addUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		try {
			// create connection to mySQL database
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			String connectionString = "jdbc:mysql://localhost:3306/my-cause-io";
			c = DriverManager.getConnection(connectionString, "root", "admin");

			// create mySQL insert statement
			String insertStatement = "INSERT INTO 'my-cause-io'.'users'('firstname','lastname', 'email', 'password')VALUES(?,?,?,?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = c.prepareStatement(insertStatement);
			insertPreparedStatement.setString(2, firstname);
			insertPreparedStatement.setString(3, lastname);
			insertPreparedStatement.setString(4, email);
			insertPreparedStatement.setString(5, password);

			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "profileSuccess";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
