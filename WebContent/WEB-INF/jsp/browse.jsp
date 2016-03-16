<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Site specific styles -->
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<!-- Site Navigation -->
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
	            <li><a href="postcause.html">Post My Cause</a></li>
	            <li><a href="search.html">Search</a></li>
	            <li class="active"><a href="browse.html">Browse</a></li>
	            <li><a href="signup.html">Sign Up</a></li>
	            <li><a href="login">Login</a></li>
				<li><a href="logout.html">Logout</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	
	
	<!-- Search Form -->
	<main>
		<p>Browse</p>
		<form action="browse.html" method="post">
		
		Select a category:<select name="category">
			<option value="0">all categories</option>
			<option value="1">money</option>
			<option value="2">time</option>
			<option value="3">food</option>
			<option value="4">material</option>
		</select><br>
		
			
			
			<input type="submit" value="Search"/>
		</form>
		
		<div class="post-preview">
			<!-- Post preview image -->
			<img src="#"/>
			<!-- Post description -->
			<p></p>
			<!-- Link to cause page -->
			<a href="">View this cause</a>
		</div>
	</main>
	
	<footer>
		<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe,
			Aaron Ribant</p>
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