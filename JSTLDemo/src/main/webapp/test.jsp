<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is JSTL Demo-1 Test page</h1>
	
	<!-- Here scope can be session, page or application
		Session : It means i is accessible throughout the session
		Page: i is limited to this page only (default scope)
		Application: It is accessible in nay page of application   -->
		
	<!-- NOTE: In index page scope of i is application that's why it is accessible here.. -->
	<c:out value="Value of i is: ${i}"></c:out>
</body>
</html>