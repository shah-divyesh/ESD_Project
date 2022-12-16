<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
</head>
<body background="Image4.jpg" style="background-size: cover;background-repeat: no-repeat;">
	<div align="right" >
		<form:form  action="employeeHome.htm" method="post"  >
		<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Home Page"/>
		</form:form>
	</div>
	
	<div align="center" ><h1>Jobs posted by ${requestScope.companyName} :</h1> 
	
		
		<%
			int status=(int)(request.getAttribute("countFlag"));
			if(status==0){
		%>
		<p style="font-style:inherit ;font-size: xx-large;color: red;border:thick;"> Sorry !! There are no recent Job Posting </p>
		<%
			}else{
		%>
			<table  border="1">
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
				         	<form action="applyJob.htm" method="post">
				         		<input type="hidden"  name="Id" value="${list.jobId}">
				         		<input type="submit" value="Apply" /> 
				         	</form>
				         </td>
				     </tr>
				     
			   </c:forEach>
			</table>
		<%
			}
		%>
		
		</div>
	
	
</body>
</html>