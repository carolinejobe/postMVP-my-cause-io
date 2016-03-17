<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>MyCause.io | Sign-up</title>
</head>
<body>
	<!-- Site Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">MyCause.io</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="index.html">Home</a></li>
					<li><a href="postcause.html">Post My Cause</a></li>
					<li><a href="search.html">Search</a></li>
					<li><a href="browse.html">Browse</a></li>
					<li id="signup" class="active"><a href="signup.html">Sign Up</a></li>
					<li id="login"><a href="login.html">Login</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


	<!-- Signup form -->
	<main>
		<div class="container">  
			<h2 class="page-header">Sign Up</h2>
			<p class="col-sm-offset-2 col-sm-10">Join our community by making an account so that you can post your causes.</p>
		</div>
	
			<form action="profileSuccess.html" method="post" class="form-horizontal">
			<div class="container">
			
				<div class="form-group">
				  <label for="firstNameInput" class="col-sm-2 control-label">First Name:</label>
				  <div class="col-sm-10">
				    <input type="text" name="firstname" class="form-control" id="firstNameInput" placeholder="Enter your first name." required/>
				  </div>
				</div>
				<div class="form-group">
				  <label for="lastNameInput" class="col-sm-2 control-label">Last Name:</label>
				  <div class="col-sm-10">
				    <input type="text" name="lastname" class="form-control" id="lastNameInput" placeholder="Enter your last name." required/>
				  </div>
				</div>
				<div class="form-group">
				  <label for="organizationInput" class="col-sm-2 control-label">Organization Name:</label>
				  <div class="col-sm-10">
				    <input type="text" name="organization" class="form-control" id="organizationInput" placeholder="Enter your organization if applicable."/>
				  </div>
				</div>
				<div class="form-group">
			    	<label for="inputEmail" class="col-sm-2 control-label">Email Address: </label>
			    	<div class="col-sm-10">
			    		<input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email Address" required/>
			    	</div>
			    </div>
				<div class="form-group">
				  <label for="inputPassword" class="col-sm-2 control-label">Password</label>
				  <div class="col-sm-10">
				    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
				  </div>
				</div>
				<div class="form-group">
				  <div class="col-sm-offset-2 col-sm-10">
				    <button type="submit" value="submit" class="btn btn-default">Join Us!</button>
				  </div>
				</div>

			</form>
	
	
	
	
	
	</main>

	<footer class="footer">
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

	<!-- Cookie JS lib scripts -->
	<script src="scripts/js.cookie.js"></script>
	<!-- Site scripts -->
	<script src="scripts/scripts.js"></script>
</body>
</html>