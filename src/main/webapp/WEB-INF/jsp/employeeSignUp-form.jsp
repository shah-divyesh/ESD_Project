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
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>
	<br><br>
	<div align="right" >
		<form:form  action="typePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to User Type Page"/>
		</form:form>
	</div>
	
	<form:form modelAttribute="employee" method="post" action="employeesignup.htm"> 
		<table>
			<tr>
				<td> FirstName :</td>
				<td><form:input path="firstName" size="30" /><font color="red"> <form:errors path="firstName" /></font> </td>
			</tr>
			<tr>
				<td> LastName :</td>
				<td><form:input path="lastName" size="30" /> <font color="red"> <form:errors path="lastName" /></font>  </td>
			</tr>
			<tr>
				<td> EmailId :</td>
				<td><form:input path="emailId" size="30" /> <font color="red"> <form:errors path="emailId" /></font>  </td>
			</tr>
			<tr>
				<td> Contact Number :</td>
				<td><form:input path="contactNumber" size="30" /> <font color="red"> <form:errors path="contactNumber" /></font>  </td>
			</tr>
			<tr>
				<td> Password :</td>
				<td><form:password path="password" size="30" /> <font color="red"> <form:errors path="password" /></font>  </td>
			</tr>
			
			<tr>
				<td colspan=2><input type="submit" value="Register" /></td>
			</tr>
		</table>
	 </form:form>
</body>
</html>