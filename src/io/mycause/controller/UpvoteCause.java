package io.mycause.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpvoteCause {

	@RequestMapping("/upvoteCause")
	public String upvotePost(){
		
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();
			
			// create mySQL insert statement.
			//"update posts set upvotes=upvotes+1 where post_id=X"
			String insertStatement = "INSERT INTO maindb.posts()";
			
			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);
			
			// execute the preparedstatement
			insertPreparedStatement.execute();
			
			return "upvoteCause";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
