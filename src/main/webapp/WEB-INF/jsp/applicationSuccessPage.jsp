<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body background="Image1.jpg" style="background-size: cover;background-repeat: no-repeat;">
		<div align="right" >
			<form:form  action="employeeHome.htm" method="post">
				<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Home Page"/>
			</form:form>
		</div>
		
		<div align="left" style="font-style:inherit ;border:thick;font-size:x-large;color: black">
			<p>Your application has been submitted for ${requestScope.jobName } </p>
		</div>
		
</body>
</html>