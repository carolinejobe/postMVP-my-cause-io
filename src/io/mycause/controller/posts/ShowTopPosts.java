package io.mycause.controller.posts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.mysql.jdbc.Statement;

@Controller
public class ShowTopPosts {

	@RequestMapping("/index")
	public ModelAndView showPosts() {
		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			Statement s = conn.createStatement();
			ResultSet results = s.executeQuery("select * from maindb.posts order by upvotes desc limit 9");

			ArrayList<Post> topPosts = new ArrayList<>();

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
				topPosts.add(tempPost);

			}
			conn.close();
			return new ModelAndView("index", "ninePosts", topPosts);

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "errorMessage", "No posts to show");
		}
	}
}