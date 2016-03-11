package io.mycause.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.mysql.jdbc.Statement;

@Controller
public class ShowTopPosts {

	@RequestMapping("/index")
	public ModelAndView showPosts() {
		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection(); 
			
			Statement s =  conn.createStatement();
			ResultSet results = s.executeQuery("select * from maindb.posts limit 10");
			
			ArrayList<Post> topPosts = new ArrayList<>();
			
			while(results.next()) {
					
					String postHeadline = results.getString(2);
					String postDescription = results.getString(3);
					Post tempPost = new Post();
					tempPost.setTitle(postHeadline);
					tempPost.setDescription(postDescription);
					
					topPosts.add(tempPost);
				
			}
			
			return new ModelAndView("index","tenPosts",topPosts);
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("showError","errorMessage", "No posts to show");
		}
	}
}