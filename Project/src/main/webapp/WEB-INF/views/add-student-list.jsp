<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Project/URLtoReachResources/css/stylesheet.css">
</head>
<body class ="b">
<div align="center">
<form:form method="POST" modelAttribute="student">
<h1>Add Student</h1>
    <label>Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><form:input path="id"/><br><br>
    <label>Name:  &nbsp;&nbsp;&nbsp; </label><form:input path="name"/><br><br>
    <label>Phone:  &nbsp;&nbsp; </label><form:input path="phone"/><br><br>
    <label>Address: </label><form:input path="address"/><br><br>
    <input type="submit" value="Submit">    
</form:form>
</div>
<br>
<div align="center">
<form action="/Project/show">
<input type="submit" value="Show All Student">
</form>
</div>
</body>
</html>