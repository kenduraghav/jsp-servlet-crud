<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Person Details</title>
</head>
<body>
<form method="post" action="AddPersonDetail">
<table>
	<c:if test="${person.id != 0}">
	<tr>
		<th>Id</th>
		<td>
			<input type="text" name="id" size="45" readonly="readonly"  
                			value="<c:out value='${person.id}'></c:out>"
                		/>
		</td>
	</tr>
	</c:if>
	<tr>
		<th>FirstName</th>
		<td>
			<input type="text" name="firstName" size="45"
                			value="<c:out value='${person.firstName}'></c:out>"
                		/>
		</td>
	</tr>
	<tr>
		<th>LastName</th>
		<td>
			<input type="text" name="lastName" size="45"
                			value="<c:out value='${person.lastName}'></c:out>"
                		/>
		</td>
	</tr>
	<tr>
		<th>Address</th>
		<td>
			<input type="text" name="address" size="45"
                			value="<c:out value='${person.address}'></c:out>"
                		/>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
	</tr>
</table>
</form>
<br><br>
<a href="index.html">Home</a> |
<a href="GetPersonDetails">List Person Details</a>
</body>
</html>