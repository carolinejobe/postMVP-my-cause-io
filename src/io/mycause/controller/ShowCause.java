package io.mycause.controller;

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
			
			//query to return selected post
			ResultSet results = s.executeQuery("select * from maindb.posts where post_id='" + id + "'"); 

			String[] postInfo = new String[7];
			if (results.next()) {

				String postHeadline = results.getString(2);
				String postDescription = results.getString(3);
				String postCategoryId = results.getString(4);
				String postUpvotes = results.getString(8);
				String userId = results.getString(9);
				int catId = results.getInt(4);
				
				ResultSet result = s.executeQuery("select email from maindb.users where user_id = ' " + userId + " '");
				String imageLink = "";

				switch (catId) {
				case 1:
					imageLink = "images/moneyIconSmall.png";
					break;
				case 2:
					imageLink = "images/timeIconSmall.png";
					break;
				case 3:
					imageLink = "images/foodIconSmall.png";
					break;
				case 4:
					imageLink = "images/resourcesIconSmall.png";
					break;

				}

				
				System.out.println(imageLink);
				postInfo[0] = postHeadline;
				postInfo[1] = postDescription;
				postInfo[2] = postCategoryId;
				postInfo[3] = postUpvotes;
				postInfo[4] = Integer.toString(id);
				postInfo[6] = imageLink;

				if (result.next())
					postInfo[5] = result.getString(1);
				conn.close();
				return new ModelAndView("cause", "info", postInfo);
			}
			else
				conn.close();
				return new ModelAndView("error", "message", "Post not found");

		} catch (Exception e) {
			e.printStackTrace();

			return new ModelAndView("error", "errorMessage", "Sorry, we couldn't find that post! Please try again.");
		}
	}

}