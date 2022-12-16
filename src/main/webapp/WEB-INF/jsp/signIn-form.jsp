<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>Sign In Page</title>
</head>
<body background="Image4.jpg" style="background-size: cover;">
	<div align="right" >
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: 30px;color: white;border:thick;background-color:black; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>
	<div align="center">
	<form:form modelAttribute="user" method="post" action="login.htm"> 
		<table>
			
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> UserName :<br><br></td> 
				<td align="justify" style="font-size: 30px; color: black"><form:input path="userName" size="30" /><font color="red"> <form:errors path="userName" /></font> <br><br></td>
			
			</tr>
			
			<tr>
				<td align="justify" style="font-size: 30px; color: black"> Password :<br><br></td>
				<td align="justify" style="font-size: 30px; color: black"><form:password path="password" size="30" /> <font color="red"> <form:errors path="password" /></font> <br><br> </td>
			</tr>
			<tr>
		        <td align="justify" style="font-size: 30px; color: black">User Type: <br><br> </td> 
		        <td align="justify" style="font-size: 30px; color: black">Employee <form:radiobutton path="userType" value="Employee"/> 
		        Employer <form:radiobutton path="userType" value="Employer"/><font color="red"> <form:errors path="userType" /></font><br><br>  </td> 
			</tr>
			<tr>
				<td align="center"  colspan=2><input type="submit" value="Sign In" style="font-size: 30px; color: black;"/></td>
			</tr>
		</table>
		
		<br>
		<br>
		<form:errors  path="*" />

	 </form:form>
	</div>
</body>
</html>