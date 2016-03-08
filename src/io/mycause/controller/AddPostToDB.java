package io.mycause.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddPostToDB {

	//need a way to identify the user making the post (behind the scenes?) so that we associate the correct foreign key with the post
	
	@RequestMapping("/postSuccess")
	public String addPost(@RequestParam("primarycategory") String primarycategory, @RequestParam("secondarycategory") String secondarycategory,
			@RequestParam("description") String description, @RequestParam("location") String location) {
		try {
			// create connection to mySQL database- this will change when we get AWS db built
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			String connectionString = "jdbc:mysql://localhost:3306/mycauseio";
			c = DriverManager.getConnection(connectionString, "root", "admin");

			// create mySQL insert statement
			String insertStatement = "INSERT INTO mycauseio.post(primarycategory,secondarycategory, description, location)VALUES(?,?,?,?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = c.prepareStatement(insertStatement);
			insertPreparedStatement.setString(1, primarycategory);
			insertPreparedStatement.setString(2, secondarycategory);
			insertPreparedStatement.setString(3, description);
			insertPreparedStatement.setString(4, location);

			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "postSuccess";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}