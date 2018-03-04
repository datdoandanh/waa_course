<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body style="margin: 0">
	<div><a href="?lang=en">English</a> | <a href="?lang=vi">Vietnamese</a></div>
	<div style="position: fixed; top: 0; right:10px;">
		<c:choose>
			<c:when test="${username == null }">
				<a href="login">Login</a>
			</c:when>
			<c:otherwise>
				Hello ${username}, 
				<a href="logout">Logout</a>
			</c:otherwise>
		</c:choose>
	</div>
	<h2>
		<spring:message code="label.welcome"></spring:message>
	</h2>
	<p>
		<sec:authorize access="hasRole('ADMIN')">
			<p>ADMIN</p>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN') or hasRole('ACCOUNTANT')">
			<p>ACCOUNTANT</p>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN') or hasRole('SALES')">
			<p>SALES</p>
		</sec:authorize>
		<spring:message code="label.please_select_one"></spring:message>
		<select>
			<option><spring:message code="label.cars"></spring:message> </option>
			<option><spring:message code="label.books"></spring:message> </option>
		</select>
	</p>
</body>
</html>
