<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>JSTL with Db page</h1>
		<h3>All users are:</h3>
		<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/Registration" user="Voldemort"
			password="#Aditya1711" var="ds" />
		<sql:query dataSource="${ds}" var="res">select * from user</sql:query>

		<table class="table">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Email</td>
			</tr>
			<a:forEach items="${res.rows }" var="row">
				<tr>
					<td><a:out value="${row.id }"></a:out></td>
					<td><a:out value="${row.name }"></a:out></td>
					<td><a:out value="${row.email }"></a:out></td>
				</tr>
			</a:forEach>
		</table>
	</div>
</body>
</html>