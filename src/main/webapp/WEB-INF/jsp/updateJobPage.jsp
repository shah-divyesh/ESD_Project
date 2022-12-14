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
	<div align="right" >
	<form:form  action="employerHome.htm" method="post"  >
		<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Home Page"/>
	</form:form>
	</div>
	
	<form:form modelAttribute="defaultJob" method="post" action="update.htm"> 
		<input type="hidden" name="updateJobId" value="${requestScope.updateJob.jobId}" />
			<table>
				<tr>
					<td> Job Title :</td>
					<td><form:input path="title" size="30" /><font color="red"> <form:errors path="title" /></font> </td>
				</tr>
				<tr>
					<td> Job Location :</td>
					<td><form:input path="location" size="30" /> <font color="red"> <form:errors path="location" /></font>  </td>
				</tr>
				<tr>
					<td> Job Description :</td>
					<td><form:input path="description" size="30" /> <font color="red"> <form:errors path="description" /></font>  </td>
				</tr>
				<tr>
					<td> Hiring Status :</td>
					<td><form:input path="status" size="30" /> <font color="red"> <form:errors path="status" /></font>  </td>
				</tr>
				
				<tr>
					<td colspan=2><input type="submit" value="Update Job" /></td>
				</tr>
			</table>
		 </form:form>
</body>
</html>