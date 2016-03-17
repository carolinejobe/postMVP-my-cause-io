<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="javax.naming.Context,javax.naming.InitialContext"%>
<%@ page import="javax.annotation.Resource"%>
<%@page import="javax.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Site specific styles -->
<link rel="stylesheet" href="css/styles.css">

 <link rel="stylesheet" type="text/css" href="css/sweetalert.css">
<title>Post For Help</title>
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
	          <a class="navbar-brand" href="index.html">MyCause.io</a>
	        </div>
	        <div id="navbar" class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
	            <li><a href="index.html">Home</a></li>
	            <li class="active"><a href="postcause.html">Post My Cause</a></li>
	            <li><a href="search.html">Search</a></li>
	            <li><a href="browse.html">Browse</a></li>
	            <li><a href="signup.html">Sign Up</a></li>
	            <li><a href="login">Login</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	
	<main> 
	<div class="container">  

	<h2 class="page-header">Post Your Cause</h2>
	<p class="col-sm-offset-2 col-sm-10">Tell us more about your cause.</p>
	</div> 
	<form action="postSuccess.html" method="post" class="form-horizontal">
	<div class="container">
		<div class="form-group">
			<label for="categorySelect" class="col-sm-2 control-label">Category</label>
			<div class="col-sm-8">
				<select name="category" class="form-control col-sm-2">
			  		<option value="1">money</option>
			  		<option value="2">time</option>
			  		<option value="3">food</option>
			  		<option value="4">material</option>
				</select>
			</div>	
		</div>
	
	  <div class="form-group">
	    <label for="inputHeadline" class="col-sm-2 control-label">Headline</label>
	    <div class="col-sm-8">
	      <input type="text" name="postheadline" maxlength="59" class="form-control" id="inputHeadline" placeholder="Enter a title (max 59 characters)" required/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
	    <div class="col-sm-8">
	      	<!-- <input type="text" name=post_desc class="form-control" id="inputDescription" placeholder="Enter a description of your cause (max 249 characters)" required/> -->
			<textarea name="post_desc" maxlength="249" id="inputDescription" placeholder="Enter a description of your cause (max 249 characters)" class="form-control" rows="3" required/></textarea>
	    </div>
	  </div>
	  
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" form="form1" value="Submit" class="btn btn-default">Submit</button>
	    </div>
	  </div>
	  </div>
	</form>
	
	</main>
	
	
	
	

	<footer>
		<div class="container">
			<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe, and Aaron Ribant.</p>
		</div>
	</footer>

	<!-- JQuery -->
	<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>


	<!-- Sweet Alert -->
	<script src="scripts/sweetalert.min.js"></script>
	<!-- Cookie JS lib scripts -->
	<script src="scripts/js.cookie.js"></script>
	<!-- Site scripts -->
	<script src="scripts/scripts.js"></script>
	
</body>
</html>