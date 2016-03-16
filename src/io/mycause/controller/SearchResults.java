package io.mycause.controller;

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

@Controller
public class SearchResults {

	
	@RequestMapping("/processSearch")
	public ModelAndView processSearch(@RequestParam("searchTerm") String searchTerm){
		try{
			//connect to database
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();
			
			String catID="";
			
			if (searchTerm.contains("time")){
				catID="1";
			}
			if (searchTerm.contains("money")){
				catID="2";
			}
			if (searchTerm.contains("food")){
				catID="3";
			}
			if (searchTerm.contains("material")){
				catID="4";
			}
			
			// create mySQL statements
			String searchStatement = "select * from maindb.posts where (post_headline like '%" + searchTerm + "%') or (post_desc like '%" + searchTerm + "%') or (cat_id like '" + catID + "')";
			// create the mySQL insert preparedstatement
			PreparedStatement searchPreparedStatement = conn.prepareStatement(searchStatement);
			
			// execute the preparedstatement
			ResultSet results = searchPreparedStatement.executeQuery();
			
			ArrayList<Post> searchResults = new ArrayList<>();
			
			while (results.next()) {

				int postId = results.getInt(1);
				String postHeadline = results.getString(2);
				String postDescription = results.getString(3);
				int postUpvotes = results.getInt(8);
				int catId = results.getInt(4);
				String imageLink = "";

				switch (catId) {
				case 1:
					imageLink = "images/moneyIconSmall.jpg";
					break;
				case 2:
					imageLink = "images/timeIconSmall.jpg";
					break;
				case 3:
					imageLink = "images/foodIconsmall.jpg";
					break;
				case 4:
					imageLink = "images/materialsIconSmall.jpg";
					break;

				}
				Post tempPost = new Post();
				tempPost.setTitle(postHeadline);
				tempPost.setDescription(postDescription);
				tempPost.setPostUpvotes(postUpvotes);
				tempPost.setPostId(postId);
				tempPost.setCatId(catId);
				tempPost.setImageLink(imageLink);
				searchResults.add(tempPost);
			}
		
		return new ModelAndView("search", "selectedPosts", searchResults);
	} catch (Exception e)

	{
		return new ModelAndView("search", "message",
				"Your search returned 0 results. Please try another search. (Hint: try searching only one search term.)");

	}
}
}
