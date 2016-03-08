<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Site Navigation -->
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="search.html">Search</a></li>
			<li><a href="login.html">Login</a></li>
			<li><a href="signup.html">Sign Up</a></li>
		</ul>
	</nav>
	
	
	<!-- Signup form -->
	<main>
		<form action="profileSuccess.html" method="post">
			First name: <input type="text" name="firstname" required/>
			Last name: <input type="text" name="lastname" required/>
			Email address: <input type="email" name="email" required/>
			Password: <input type="password" name="password" required/>
			<input type="submit" value="Submit"/>
		</form>
	</main>
	
	<footer>
		<p>&copy; All rights reserved by Jeseekia Vaughn, Caroline Jobe, Aaron Ribant, and Mark Day</p>
	</footer>
</body>
</html>