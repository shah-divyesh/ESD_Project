<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body  background="Image5.jpg" style="background-size: cover">
	
	<div align="right" >
	<form:form  action="logout.htm" method="get" modelAttribute="jobs" >
		<input  style="font-style:inherit ;font-size: 30px;color: white;border:thick;background-color:black; " type="submit" value="Logout"/>
	</form:form>
	</div>
	<br><br>
	<div align="center" style="font-style: oblique;font-size: larger;color: navy;border:thick; ">
	<form:form  action="createnewjob.htm" method="get" modelAttribute="jobs" >
		<input style="font-size: 30px; color: black;" type="submit" value="Create New Job"/>
	</form:form>
	</div>
	<br><br>
	<div align="center" style="font-style: oblique;font-size: larger;color: navy;border:thick; ">
	<form:form  action="jobList.htm" method="post" modelAttribute="jobs" >
		<input style="font-size: 30px; color: black;" type="submit" value="View All created Jobs"/>
	</form:form>
	</div>
</body>
</html>