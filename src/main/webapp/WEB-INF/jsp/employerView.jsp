<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs View Page</title>
</head>
<body background="Image5.jpg" style="background-size: cover">
	 <div align="right" >
		<form:form  action="employerHome.htm" method="post"  >
		<input  style="font-style:inherit ;font-size:x-large; ;color: white;border:thick;background-color:black;" type="submit" value="Go to Home Page"/>
		</form:form>
	</div>
	
	<div align="center">
	<table border="1">
	<tr>
         <td>Job ID</td>
         <td>Job Title</td>
         <td>Job Location</td>
         <td>Job Description</td>
         <td>Job Status</td>
     </tr>
		 <c:forEach items="${requestScope.jobList}" var="list">
		     <tr>
		         <td>${list.jobId}</td>
		         <td>${list.title}</td>
		         <td>${list.location}</td>
		         <td>${list.description}</td>
		         <td>${list.status}</td>
		         <td>
		         	<form action="updateJob.htm" method="post">
		         		<input type="hidden"  name="Id" value="${list.jobId}">
		         		<input type="submit" value="Edit" /> 
		         	</form>
		         </td>
		         <td>
		         	<form action="deleteJob.htm" method="post">
		         		<input type="hidden"  name="Id" value="${list.jobId}">
		         		<input type="submit" value="Delete" /> 
		         	</form>
		         </td>
		     </tr>
	   </c:forEach>
	</table>
	</div>

	<!--   -->
</body>
</html>