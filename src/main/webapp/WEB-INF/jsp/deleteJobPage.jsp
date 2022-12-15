<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<br><br>
	<div>
		<%
			
			int status=(int)(request.getAttribute("status"));
			if(status==0){
		%>
		<p style="font-style:inherit ;font-size: xx-large;color: red;border:thick;"> Sorry !! You cannot delete ${requestScope.deleteJob} job</p>
		<%
			}else{
		%>
		<p style="font-style:inherit ;color: blue;border:thick;font-size: xx-large;"> Congratulations!! You successfully delete ${requestScope.deleteJob} job</p>
		<%
			}
		%>
	</div>
</body>
</html>