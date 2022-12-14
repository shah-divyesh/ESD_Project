<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>
	<div align="right" >
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>

	<form action="signup.htm" method="post">
		<h1>Choose the type of Sign Up </h1>
		<input type="radio" name="signUpType" value="Employer Sign Up" />Employer <br><br>
		<input type="radio" name="signUpType" value="Employee Sign Up" />Employee <br><br>
		<input type="Submit" value="Sign Up" />
	</form>
</body>
</html>