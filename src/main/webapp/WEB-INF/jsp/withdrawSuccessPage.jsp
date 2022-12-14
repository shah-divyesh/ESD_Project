<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div align="left" style="font-style:inherit ;border:thick;font-size:x-large;color:maroon;">
			<p>Your application for  ${requestScope.jobName } has been successfully withdrawn </p>
		</div>
		<div align="right" >
			<form:form  action="employeeHome.htm" method="post">
				<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Home Page"/>
			</form:form>
		</div>
</body>
</html>