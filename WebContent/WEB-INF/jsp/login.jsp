<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Site specific styles -->
<link rel="stylesheet" href="css/styles.css">
<title>MyCause.io</title>
</head>
<body>
	<!-- --------------------------- START SITE NAVIGATION BAR ------------------------ -->
	
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MyCause.io</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.html">Home</a></li>
			<li><a href="search.html">Search</a></li>
			<li><a href="postcause.html">Post Cause</a></li>
			<li class="active"><a href="login.html">Login</a></li>
			<li><a href="signup.html">Sign Up</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    	<!-- --------------------------- END SITE NAVIGATION BAR ------------------------ -->
    
    
    <!-- ------------------------------ START PANEL ADDED FOR SPACING ------------------ -->
    
    <div class="panel panel-default">
  <div class="panel-body">
    Basic panel example
  </div>
</div>

    <!-- ------------------------------ END PANEL ADDED FOR SPACING ------------------ -->
	
	    <!-- ------------------------------ START COOKIE TEST CODE ------------------ -->
	    
<%-- 	    <% 
// 		Cookie[] clientCookies = request.getCookies();
// 		if (clientCookies == null) {
// 			out.println("No cookie");
// 		} else if(clientCookies != null){
// 			out.println("cookie detected");
// // CODE TO SEND TO ANOTHER PAGE	response.sendRedirect("profileSuccess.html");
// 		}else{
// 			out.println("what the hell...");
// 		}
<%-- 	    %> --%>
	    <!-- ------------------------------ END COOKIE TEST CODE ------------------ -->
	
	
	
	<!-- Login form -->
	<main>
		<form action="processlogin.html" method="post">
			Enter your email address: <input type="email" name="email" required/>
			Enter your password: <input type="password" name="password" required/>
			<input type="submit" value="Login"/>
		</form>
	</main>
	
	<footer>
		<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe,
			Aaron Ribant, and Mark Day</p>
	</footer>
	
	<!-- JQuery -->
	<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
	<!-- Site scripts -->
	<script src="scripts/scripts.js"></script>
	
	

	
</body>
</html>