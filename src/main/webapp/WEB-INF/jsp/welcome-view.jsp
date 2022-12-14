<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en"
  xmlns:th="http://www.thymeleaf.org"
>
<head>
    <meta charset="UTF-8">
    <title>Registration and Login System</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <div class="container-fluid" >
    <h1><font style="font-size: 20px; color: white;"> Welcome to Job Board Application</font></h1>
    
  </div>
</nav>
<div style="background-color:cyan;height: 1200px">
<br><br>
	
	<form action="welcome.htm" method="post">
		<p ><input type="radio" name="info" value="Sign In"/> Sign In</p>
		<p><input type="radio" name="info" value="Sign Up"/> Create New User</p>
		<input type="submit">
	</form>
	</div>
</body>
</html>