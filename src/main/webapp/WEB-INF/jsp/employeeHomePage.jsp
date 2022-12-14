<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page session="true" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right" >
	<form:form  action="logout.htm" method="get" modelAttribute="jobs" >
		<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Logout"/>
	</form:form>
	</div>

	<div align="center" ><h1>Recent Jobs posted :</h1> </div>
	<table border="1">
	<tr>
         <td>Job ID</td>
         <td>Job Title</td>
         <td>Job Location</td>
         <td>Job Description</td>
         <td>Job Status</td>
     </tr>
		 <c:forEach items="${list}" var="list">
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


	<p align="center" ><h1>You applied to following jobs :</h1>
	<table border="1">
	<c:forEach items="${appliedJobs}" var="list1">
		     <tr>
		         <td>${list1.jobId}</td>
		         <td>${list1.title}</td>
		         <td>${list1.location}</td>
		         <td>${list1.description}</td>
		         <td>${list1.status}</td>
		         <td>
		         	<form action="withdraw.htm" method="post">
		         		<input type="hidden"  name="withdrawId" value="${list1.jobId}">
		         		<input type="submit" value="Withdraw Application" /> 
		         	</form>
		         </td>
		     </tr>
	   </c:forEach>
	   </table>
	
</body>
</html>