<!-- 508170222 Nick Chen, 508170301 Matt Hsiao  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="LoginPageCss.css">
<title>Login Page</title>
</head>
<body>

<!-- Login section -->
<div id=login>
LOGIN
	<form action="Login" method="post">
		Enter    id    : <input type="text" name="id"><br>
		Enter password : <input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
</div>

<div id=or>
	or
</div>

<!-- Sign up section -->
<div id=signUp>
SIGN UP
 	<form action="SignUp" method="post">
 		Id to sign up: <input type="text" name="id"><br>
 		Password to sign up: <input type="text" name="password"><br>
 		<input type="submit" value="register">
 	</form>
 </div>
</body>
</html>