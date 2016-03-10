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
public class AddPostToDB {

	@RequestMapping("/postSuccess")
	public String addPost(@RequestParam("category") String category, @RequestParam("postheadline") String postheadline,
			@RequestParam("post_desc") String post_desc) {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			// create mySQL insert statement.
			// need to update insertStatement to account for jumping with FKs:
			// user selects a category, need to update post table with that
			// cat_ID.
			// -->!! also need to populate the user_id based on who is logged in
			// when post is created.
			String insertStatement = "INSERT INTO maindb.posts(post_headline, post_desc, cat_id)VALUES(?, ?, ?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);
			insertPreparedStatement.setString(1, postheadline);
			insertPreparedStatement.setString(2, post_desc);
			insertPreparedStatement.setString(3, category);
			
			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "postSuccess";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}