<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page isErrorPage="true" %>

<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
	<!-- // Here exception is an inplicit object which holds the error which is occurred -->
	<h1>Sorry!! Something went wrong... <br><%= exception %> </h1>
</body>
</html>