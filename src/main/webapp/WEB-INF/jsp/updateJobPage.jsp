<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body background="Image4.jpg" style="background-size: cover">
	<div align="right" >
		<form:form  action="employerHome.htm" method="post"  >
		<input  style="font-style:inherit ;font-size:x-large; ;color: white;border:thick;background-color:black;" type="submit" value="Go to Home Page"/>
		</form:form>
	</div>
	
	<div align="center">
	<h1>Updating Job</h1>
	<form:form modelAttribute="defaultJob" method="post" action="update.htm"> 
		<input type="hidden" name="updateJobId" value="${requestScope.updateJob.jobId}" />
		<table>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Job Title :<br><br></td>
				<td><form:input path="title" size="30" /><font color="red"> <form:errors path="title" /></font> <br><br></td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Job Location :<br><br></td>
				<td><form:input path="location" size="30" /> <font color="red"> <form:errors path="location" /></font>  <br><br></td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Job Description :<br><br></td>
				<td><form:input path="description" size="30" /> <font color="red"> <form:errors path="description" /></font> <br><br> </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Hiring Status :<br><br></td>
				<td><form:input path="status" size="30" /> <font color="red"> <form:errors path="status" /></font><br><br>  </td>
			</tr>
			
			<tr>
				<td align="center"  colspan=2><input type="submit" value="Update Job" style="font-size: 30px;"  /><br><br></td>
			</tr>
		</table>
	 </form:form>
	 </div>
</body>
</html>