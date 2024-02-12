<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.tomcat-demo.com/testing" prefix="customTag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<customTag:mytag></customTag:mytag>
	<br>
	<hr>
	<br>
	<customTag:tableTag number="10" color="red"></customTag:tableTag>
	<customTag:tableTag number="100" color="purple"></customTag:tableTag>
</body>
</html>