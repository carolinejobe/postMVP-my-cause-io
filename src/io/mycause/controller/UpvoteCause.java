package io.mycause.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpvoteCause {

	@RequestMapping(value="/upvote", method=RequestMethod.GET)
	public String upvotePost(@RequestParam("postId") int id) {

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			// create mySQL insert statement.
			// --> make syntax below the insertStatement once we have a way to determine
			// what the post_id is: "update posts set upvotes=upvotes+1 where post_id=X"
			
			String insertStatement = "UPDATE maindb.posts set upvotes=upvotes+1 where post_id='" + id + "'";

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);

			// execute the preparedstatement
			insertPreparedStatement.execute();

			return "cause";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
