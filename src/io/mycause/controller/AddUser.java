package io.mycause.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddUser {

	@RequestMapping("/profileSuccess")
	public String addUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("organization") String organization) {
		try {
//			// create connection to mySQL database
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn;
//			String connectionString = "jdbc:mysql://localhost:3306/mycauseio";
//			conn = DriverManager.getConnection(connectionString, "root", "admin");
////////////
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection(); 
	//		Statement st= conn.createStatement(); 
////////////			
			
			// create mySQL insert statement
			String insertStatement = "INSERT INTO maindb.users(firstname,lastname, email, password, organization)VALUES(?,?,?,?,?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);
			
			
			insertPreparedStatement.setString(1, firstname);
			insertPreparedStatement.setString(2, lastname);
			insertPreparedStatement.setString(3, email);
			insertPreparedStatement.setString(4, password);
			insertPreparedStatement.setString(5, organization);

			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "profileSuccess";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			return "error";
		}
	}
}
