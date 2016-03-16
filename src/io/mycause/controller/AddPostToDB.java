package io.mycause.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddPostToDB {

	@RequestMapping("/postSuccess")
	public ModelAndView addPost(@RequestParam("category") int category,
			@RequestParam("postheadline") String postheadline, @RequestParam("post_desc") String post_desc,
			HttpServletRequest request) {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			// get user_id from cookie and cast to int
			Cookie[] clientCookies = request.getCookies();
			String userID = "";
			int userIDint;
			userID = clientCookies[1].getValue();
			userIDint = Integer.parseInt(userID);

			// create mySQL insert statement.
			String insertStatement = "INSERT INTO maindb.posts(post_headline, post_desc, cat_id, user_id)VALUES(?, ?, ?, ?)";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);
			insertPreparedStatement.setString(1, postheadline);
			insertPreparedStatement.setString(2, post_desc);
			insertPreparedStatement.setInt(3, category);
			insertPreparedStatement.setInt(4, userIDint);

			// execute the preparedstatement
			insertPreparedStatement.execute();
			
			// get the newly created postID
			Statement s = conn.createStatement();
			ResultSet results = s.executeQuery("select last_insert_id() from maindb.posts");
			String postID = "";
			if (results.next()) {
				postID = results.getString(1);
			}
			return new ModelAndView("redirect:/cause.html?postId="+ postID);

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "message", "Sorry, something happened. Please go back and try again.");
		}
	}
}