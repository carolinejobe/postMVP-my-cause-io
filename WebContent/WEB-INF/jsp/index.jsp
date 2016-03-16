<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>MyCause.io</title>
</head>
<body>

		
		
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
	            <li class="active"><a href="index.html">Home</a></li>
	            <li><a href="postcause.html">Post My Cause</a></li>
	            <li><a href="login">Login</a></li>
	            <li><a href="signup.html">Sign Up</a></li>
				<li><a href="logout.html">Logout</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>

	
		<!-- Content wrapper; all original content goes inside of this div: -->
		
			<header>
				<!-- Carousel ================================================== -->
				    <div id="myCarousel" class="carousel slide" data-ride="carousel">
				      <!-- Indicators -->
				      <ol class="carousel-indicators">
				        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				        <li data-target="#myCarousel" data-slide-to="1"></li>
				        <li data-target="#myCarousel" data-slide-to="2"></li>
				      </ol>
				      <div class="carousel-inner" role="listbox">
				        <div class="item active">
				          <img class="first-slide" src="images/silhouetteBanner.jpg" alt="First slide">
				          <div class="container">
				            <div class="carousel-caption">
				              <h1>Example headline.</h1>
				              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
				              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
				            </div>
				          </div>
				        </div>
				        <div class="item">
				          <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
				          <div class="container">
				            <div class="carousel-caption">
				              <h1>Another example headline.</h1>
				              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
				            </div>
				          </div>
				        </div>
				        <div class="item">
				          <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
				          <div class="container">
				            <div class="carousel-caption">
				              <h1>One more for good measure.</h1>
				              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
				            </div>
				          </div>
				        </div>
				      </div>
				      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				        <span class="sr-only">Previous</span>
				      </a>
				      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				        <span class="sr-only">Next</span>
				      </a>
				    </div><!-- /.carousel -->
			
			
			 </header>
			<!-- List of postings based on upvotes -->
			<main> 
				<div class="container">
				<c:forEach var="myvar" items="${tenPosts}">
				<div class="row">
					<div class="post-preview">
							<!-- Post preview image -->
							<img src="${myvar.getImageLink()}" />
							<!-- Post title -->
							<h2>${myvar.getTitle()}</h2>
							<!-- Post description -->
							<p>${myvar.getDescription()}</p>
							<p>Upvotes: ${myvar.getPostUpvotes() }</p>
							<form action="cause.html">
								<input type="hidden" name="postId" value="${myvar.getPostId()}" />
								<input type="hidden" name="catId" value="${myvar.getCatId()}" />
								<input type="submit" value="visit" name="visit" />
							</form>
					</div>
				</div>
			</c:forEach> 
			</div>
			</main>
			<!-- End content block -->






	<footer>
		<div class="container">
		<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe,
			Aaron Ribant.</p>
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

	<!-- Site scripts -->
	<script src="scripts/scripts.js"></script>

</body>
</html>