<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<!-- Site Navigation -->
	<nav class="">
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
            <li class="active"><a href="index.html">Home</a></li>
			<li><a href="search.html">Search</a></li>
			<li><a href="postcause.html">Post Cause</a></li>
			<li><a href="login.html">Login</a></li>
			<li><a href="signup.html">Sign Up</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	<!-- Header for photo -->
	<header>
		
	</header>
	
	<!-- List of postings based on upvotes -->
	<main class="container">
		
		
		<c:forEach var="myvar" items="${tenPosts}">
			<div class="post-preview">
				<!-- Post preview image -->
				<img src="#"/>
				<!-- Post title -->
				<h2>${myvar.getTitle()}</h2>
				<!-- Post description -->
				<p>${myvar.getDescription()}</p>
				<p>Upvotes: ${myvar.getPostUpvotes() }</p>
				<form action="cause.html">
					<input type="hidden" name="postId" value="${myvar.getPostId()}"/>
					<input type="submit" value="visit" name="visit"/>
				</form>
			</div>
			
		
		</c:forEach>
	</main>
	
	<footer class="container">
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