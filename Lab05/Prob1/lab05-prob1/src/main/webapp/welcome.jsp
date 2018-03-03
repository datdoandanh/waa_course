<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body style="margin: 0">
	<div><a href="?lang=en">English</a> | <a href="?lang=vi">Vietnamese</a></div>
	<div style="position: fixed; top: 0; right:10px;"><a href="login">Login</a></div>
	<h2>
		<spring:message code="label.welcome"></spring:message>
	</h2>
	<p>
		<spring:message code="label.please_select_one"></spring:message>
		<select>
			<sec:authorize access="hasRole('ADMIN', 'SALES')">
				<option><spring:message code="label.cars"></spring:message> </option>
			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN', 'BOOKS')">
				<option><spring:message code="label.books"></spring:message> </option>
			</sec:authorize>
		</select>
	</p>
</body>
</html>
