package io.mycause.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Controller
public class PostCause {

	@RequestMapping("/postcause")
	public String populateCatMenu() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbb");
			Connection conn = ds.getConnection();

			// error message for line below: "datasource is null" -->
			// <sql:query dataSource="${myvar}" var="result">
			// SELECT * from category;
			// </sql:query>
			//

			return "postcause";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace());
			return "error";
		}
	}

}