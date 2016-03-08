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
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '1542145579413377',
				xfbml : true,
				version : 'v2.5'
			});
		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Twitter JS code -->
	var link = document.createElement('a'); link.setAttribute('href',
	'https://twitter.com/share'); link.setAttribute('class',
	'twitter-share-button'); link.setAttribute('style', 'margin-top:5px;');
	link.setAttribute("data-text" , "I just helped someone!;
	link.setAttribute("data-via" ,"denvycom") ;
	link.setAttribute("data-size" ,"large") ;
	this.lowermessageContainer.appendChild(link) ; twttr.widgets.load();
	//very important

	<!-- Site Navigation -->
	<nav>
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">Search</a></li>
			<li><a href="#">Login</a></li>
			<li><a href="#">Sign Up</a></li>
		</ul>
	</nav>

	<a href="imageofRecipient.jpg"></a>

	<p>Placeholder text. Will be description of cause populated from
		recipient's post page.</p>



	<button type="button" class="btn btn-default">Upvote!</button>
	<button type="button" class="btn btn-default">Connect</button>

	<!-- Facebook like/share buttons -->
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