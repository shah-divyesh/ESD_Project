<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration form example</title>
<link rel="stylesheet" type="text/css" href="formatting.css">
</head>

<body>
	
	<div align="right" >
		<form:form  action="employerHome.htm" method="post"  >
		<input  style="font-style:inherit ;font-size: larger;color: white;border:thick;background-color:darkslateblue; " type="submit" value="Go to Home Page"/>
		</form:form>
	</div>
	
	<div class="main">
	<h1>Creating New Job</h1>
		<!--  --><div class="form1">
		<form:form modelAttribute="jobs" method="post"> 
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
					<td colspan=2><input type="submit" value="Create Job" /></td>
				</tr>
			</table>
		 </form:form>
		 </div>
	 </div>
</body>
</html>