<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cause Description</title>
</head>

<body>

	<!-- Facebook share JS SDK -->
	<div id="fb-root"></div>
	<script type="text/javascript">
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Site Navigation -->
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="search.html">Search</a></li>
			<li><a href="login.html">Login</a></li>
			<li><a href="signup.html">Sign Up</a></li>
		</ul>
	</nav>
	
	<main>
		<!-- Account avatar -->
		<img src= ""/>
		<!-- Cause description -->
		<p>
		</p> 
		
		<!-- Form for adding upvote to this post -->
		<form action="">
			<button type="button">Upvote!</button>
		</form>
		<form action="">
			<button type="button">Connect</button>
		</form>


	<!-- Facebook like/share buttons -->
	<!--  -->
	<div class="fb-like" data-href="http://www.mycause.io"
		data-layout="standard" data-action="like" data-show-faces="true"
		data-share="true"></div>
	<div class="fb-share-button" data-href="http://www.mycause.io"
		data-layout="icon_link"></div>
	<br>

	<!-- Twitter button -->
	<a href="https://twitter.com/share" class="twitter-share-button"
		data-text="I just helped someone!" data-size="large">Tweet</a>
	<script>
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
					.test(d.location) ? 'http' : 'https';
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = p + '://platform.twitter.com/widgets.js';
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, 'script', 'twitter-wjs');
	</script>


	</main>

	<footer>
		<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe,
			Aaron Ribant, and Mark Day</p>
	</footer>
</body>
</html>