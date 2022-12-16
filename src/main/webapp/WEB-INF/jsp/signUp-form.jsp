<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body background="Image3.jpg" style="background-size: cover;">
	<div align="right" >
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: 40px;color: white;border:thick;background-color:black; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>

	<form action="signup.htm" method="post">
		<p  align="justify" style="font-size: 50px; color: black"> Choose the type of Sign Up  </p>
		<p  align="justify" style="font-size: 30px; color: black"><input type="radio" name="signUpType" value="Employer Sign Up" />Employer</p>
		<p  align="justify" style="font-size: 30px; color: black"><input type="radio" name="signUpType" value="Employee Sign Up" />Employee </p>
		<p  align="justify" style="font-size: 30px; color: black"><input type="Submit" value="Sign Up"  style="font-size: 30px;"/></p>
	</form>
</body>
</html>