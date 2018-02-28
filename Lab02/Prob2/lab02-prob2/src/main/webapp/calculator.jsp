<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<form action="" method="post">
		<input type="number" name="num1" value="${num1}"/>+<input type="number" name="num2" value="${num2}"/> = <input type="number" name="sum" value="${sum}"/>
		<br />
		<input type="number" name="num3" value="${num3}"/>*<input type="number" name="num4" value="${num4}"/> = <input type="number" name="multiply" value="${multpliy}"/> 
		<br />
		<input type="submit" value="submit" />
	</form>
</body>
</html>