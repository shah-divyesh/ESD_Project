<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS Login Page Template - W3jar.Com</title>
    <link href="https://fonts.googleapis.com/css2?family=Muli:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/src/main/resources/static/style-with-prefix.css">
    <style>
        .srouce{
            text-align: center;
            color: #ffffff;
            padding: 10px;
        }
    </style>

</head>
<body>
	<div align="right" >
		<form:form  action="welcomePage.htm" method="post">
			<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Welcome Page"/>
		</form:form>
	</div>
	<form:form modelAttribute="user" method="post" action="login.htm"> 
		<table>
			<tr>
				<td> UserName :</td>
				<td><form:input path="userName" size="30" /><font color="red"> <form:errors path="userName" /></font> </td>
			</tr>
			<tr>
				<td> Password :</td>
				<td><form:password path="password" size="30" /> <font color="red"> <form:errors path="password" /></font>  </td>
			</tr>
			<tr>
		        <td>User Type:  </td> 
		        <td>Employee <form:radiobutton path="userType" value="Employee"/> 
		        Employer <form:radiobutton path="userType" value="Employer"/><font color="red"> <form:errors path="userType" /></font>  </td> 
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="Sign In" /></td>
			</tr>
		</table>
		<form:errors path="*" />

	 </form:form> 
</body>
</html>