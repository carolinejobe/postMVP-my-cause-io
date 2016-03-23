package io.mycause.controller.browse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.mycause.controller.posts.Post;

@Controller
public class Browse {

	@RequestMapping("/processBrowse")
	public ModelAndView processBrowse(@RequestParam("category") String category, @RequestParam("sort") String sort) {

		try {
			//connect to database
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();
			
			if(category.equals("0")){
				category="1,2,3,4";
			}
			
			// create mySQL statements
			String browseStatement = "select * from maindb.posts where cat_id in (" + category + ") order by " + sort;
			// create the mySQL insert preparedstatement
			PreparedStatement browsePreparedStatement = conn.prepareStatement(browseStatement);
			
			// execute the preparedstatement
			ResultSet results = browsePreparedStatement.executeQuery();
			
			ArrayList<Post> browsePosts = new ArrayList<>();
			
			while (results.next()) {

				int postId = results.getInt(1);
				String postHeadline = results.getString(2);
				String postDescription = results.getString(3);
				int postUpvotes = results.getInt(8);
				int catId = results.getInt(4);
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
				Post tempPost = new Post();
				tempPost.setTitle(postHeadline);
				tempPost.setDescription(postDescription);
				tempPost.setPostUpvotes(postUpvotes);
				tempPost.setPostId(postId);
				tempPost.setCatId(catId);
				tempPost.setImageLink(imageLink);
				browsePosts.add(tempPost);

			}
			conn.close();
			return new ModelAndView("browse", "selectedPosts", browsePosts);
		} catch (Exception e)

		{
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			return new ModelAndView("browse", "message",
					"There was an issue processing your request. Please try again.");

		}
	}
}
