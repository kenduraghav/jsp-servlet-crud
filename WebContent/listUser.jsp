<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Person Details</title>
</head>
<body>
<table>
	<thead>
	<tr>
		<th>Id</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Address</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${persons}" var="person">
		<tr>
			<td><c:out value="${person.id}"></c:out> </td>
			<td><c:out value="${person.firstName}"></c:out> </td>
			<td><c:out value="${person.lastName}"></c:out> </td>
			<td><c:out value="${person.address}"></c:out> </td>
			<td><a href="GetPersonDetails?action=edit&id=<c:out value='${person.id}'/>" >Edit</a>
			<td><a href="GetPersonDetails?action=delete&id=<c:out value='${person.id}'/>">Delete</a>
		</tr>
		</c:forEach>
	</tbody>
</table>
<br><br>
<a href="index.html">Home</a> |
<a href="addPerson.jsp">Add Person Details</a>
</body>
</html>









