package io.mycause.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddPostToDB {

	@RequestMapping("/postSuccess")
	public String addPost(@RequestParam("category") String category, @RequestParam("postheadline") String postheadline,
			@RequestParam("post_desc") String post_desc) {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection(); 
			
			// create mySQL insert statement.
			// need to update insertStatement to account for jumping with FKs:
			// user selects a category, need to update post table with that cat_ID.
			// -->!! also need to populate the user_id based on who is logged in when post is created. 
			String insertStatement = "INSERT INTO maindb.posts(user_id, post_headline, cat_id, post_desc)VALUES(?,?,?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);
			insertPreparedStatement.setString(1, postheadline);
			insertPreparedStatement.setString(2, category);
			insertPreparedStatement.setString(3, post_desc);

			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "postSuccess";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}