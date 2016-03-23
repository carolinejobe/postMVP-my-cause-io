package io.mycause.controller.posts;

import java.sql.Connection;
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
public class ShowCause {

	@RequestMapping("/cause")
	public ModelAndView helloWorld(@RequestParam("postId") int id) {
		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			Statement s = conn.createStatement();
			Statement statementObject = conn.createStatement();

			// query to return selected post
			ResultSet results = s.executeQuery("select * from maindb.posts where post_id='" + id + "'");

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

		} catch (

		Exception e)

		{
			e.printStackTrace();

			return new ModelAndView("error", "errorMessage", "Sorry, we couldn't find that post! Please try again.");
		}
	}

}