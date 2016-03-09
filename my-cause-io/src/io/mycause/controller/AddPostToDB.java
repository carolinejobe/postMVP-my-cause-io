package io.mycause.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddPostToDB {

	@RequestMapping("/postSuccess")
	public String addPost(@RequestParam("category") String category, @RequestParam("postheadline") String postheadline,
			@RequestParam("post_desc") String post_desc) {
		try {
			// create connection to mySQL database- this will change when we get
			// AWS db built
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			String connectionString = "jdbc:mysql://mycauseio.c8vanjxufcpj.us-west-2.rds.amazonaws.com:3306";
			c = DriverManager.getConnection(connectionString, "root", "admin");

			// create mySQL insert statement.
			// need to update insertStatement to account for jumping with FKs:
			// user selects a category, need to update post table with that cat_ID.
			// -->!! also need to populate the user_id based on who is logged in when post is created. 
			String insertStatement = "INSERT INTO maindb.post(post_headline, cat_id, post_desc, )VALUES(?,?,?,?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = c.prepareStatement(insertStatement);
			insertPreparedStatement.setString(1, category);
			insertPreparedStatement.setString(2, postheadline);
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