package io.mycause.controller.posts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpvoteCause {

	@RequestMapping(value="/upvote")
	public ModelAndView upvotePost(@RequestParam("postId") int id) {

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			// create mySQL insert statement.
			// --> make syntax below the insertStatement once we have a way to determine
			// what the post_id is: "update posts set upvotes=upvotes+1 where post_id=X"
			
			String insertStatement = "UPDATE maindb.posts set upvotes=upvotes+1 where post_id=" + id ;

			// create the mySQL insert preparedstatement
			PreparedStatement insertPreparedStatement = conn.prepareStatement(insertStatement);

			// execute the preparedstatement
			insertPreparedStatement.execute();
			
			//repopulate page with cause info
			conn = ds.getConnection();
			Statement s = conn.createStatement();
			Statement statementObject = conn.createStatement();

			//query to return that exact post and related details
			ResultSet results = s.executeQuery("select * from maindb.posts where post_id="+id); 

			String[] postInfo = new String[7];

			while (results.next()) {

				String postHeadline = results.getString(2);
				String postDescription = results.getString(3);
				int postUpvotes = results.getInt(8);
				int catId = results.getInt(4);

				Post tempPost = new Post();
				tempPost.setTitle(postHeadline);
				tempPost.setDescription(postDescription);
				tempPost.setPostUpvotes(postUpvotes);
				tempPost.setCatId(catId);
				tempPost.setImageLink(catId);

				String userId = results.getString(9);

				postInfo[0] = postHeadline;
				postInfo[1] = postDescription;
				postInfo[2] = Integer.toString(catId);
				postInfo[3] = Integer.toString(postUpvotes);
				postInfo[4] = Integer.toString(id);
				postInfo[6] = tempPost.getImageLink();
				
				ResultSet result = statementObject.executeQuery("select email from maindb.users where user_id = ' " + userId + " '");

				while (result.next()) {
					postInfo[5] = result.getString(1);
				}
				}
			conn.close();
			return new ModelAndView("cause", "info", postInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView ("error", "message", e.getMessage());
		}
	}
}
