<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a Book</title>
</head>
<body>
	<form:form action="/books/addBook" method="post" modelAttribute="book" >
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input type="text" path="title" /></td>
				<td><form:errors path="title" ></form:errors></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input type="text" path="ISBN" /> </td>
				<td><form:errors path="ISBN" ></form:errors></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input type="text" path="author" /> </td>
				<td><form:errors path="author" ></form:errors></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input type="text" path="price" /> </td>
				<td><form:errors path="price" ></form:errors></td>
			</tr>
		</table>
		<input type="submit"/>
	</form:form>
</body>
</html>