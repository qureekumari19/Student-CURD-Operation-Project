<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Project/URLtoReachResources/css/stylesheet.css">
</head>
<body class="a">
	<h1 align="center">Student-List</h1>
	<div align="center" class="a1">
		<form action="/Project/add" class="add">
			<input type="submit" value="Add">
		</form>
		<br>
		<table border="1" style="border-radius: 1.5;">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Phone</td>
					<td>Address</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${stulist}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.phone}</td>
					<td>${student.address}</td>										
					    <td><a href="/Project/update?userID=${student.id}">Update</a></td>
					       <td><a href="/Project/delete?userID=${student.id}" onclick="if(!(confirm('Are you sure you want to delete it?'))) return false" >Delete</a></td>    
					    </tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
