<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  background="Image4.jpg" style="background-size: cover">
	<div align="right" >
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size:x-large; ;color: white;border:thick;background-color:black; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>
	<br><br>
	<div align="right" >
		<form:form  action="typePage.htm" method="post">
			<input  style="font-style:inherit ;font-size:x-large;color: white;border:thick;background-color:black; " type="submit" value="Go to User Type Page"/>
		</form:form>
	</div>
	
	<div align="center">
	<form:form modelAttribute="employee" method="post" action="employeesignup.htm"> 
		<table>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> FirstName :</td>
				<td ><form:input  path="firstName" size="30" /><font color="red"> <form:errors path="firstName" /></font><br><br> </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> LastName :</td>
				<td><form:input path="lastName" size="30" /> <font color="red"> <form:errors path="lastName" /></font><br> <br> </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> EmailId :</td>
				<td><form:input path="emailId" size="30" /> <font color="red"> <form:errors path="emailId" /></font><br> <br> </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Contact Number :</td>
				<td><form:input path="contactNumber" size="30" /> <font color="red"> <form:errors path="contactNumber" /></font> <br> <br> </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Password :</td>
				<td><form:password  path="password" size="30" /> <font color="red"> <form:errors path="password" /></font><br> <br>  </td>
			</tr>
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Confirm Password :</td>
				<td><form:password path="confirm_pwd" size="30" /> <font color="red"> <form:errors path="confirm_pwd" /></font> <br><br>  </td>
			</tr>
			<tr>
				<td align="center" colspan=2><input type="submit" value="Register" style="font-size: 30px;" /> <br><br> </td>
			</tr>
		</table>
		<br>
		<br>
		<font color="red" style="font-style:inherit ;font-size:30px;border:thick;"><form:errors path="*" /></font>
		</form:form>
		</div>
</body>
</html>