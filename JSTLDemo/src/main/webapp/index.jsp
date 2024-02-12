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
	<h1>This is JSTL Demo-1 Index page</h1>
	
	<!-- 1. set -->
	<!-- Here scope can be session, page or application
		Session : It means i is accessible throughout the session
		Page: i is limited to this page only (default scope)
		Application: It is accessible in nay page of application   -->
	<c:set var="i" value="50" scope="application"></c:set>
	
	<h1>
		<!-- 2. out -->
		<c:out value="Value of i is: ${i}"></c:out>
	</h1>
	<br>
	
	<!-- 3. remove -->
	<!-- remove value of i -->
	<c:remove var="i"/>
	
	<h1>
		<c:out value="${i}">The i is empty</c:out>
	</h1>	
	<br>
	
	<hr>
		
	<c:set var="i" value="50" scope="application"></c:set>
	<c:set var="j" value="100" scope="application"></c:set>
	<!-- 4. if -->
	<c:if test="${i < 100}">
		<h1>i is less than j</h1>
	</c:if>
	
	<!-- 5. foreach -->
	<c:forEach var="j" begin="1" end = "10">
		<h1>The value of j is: <c:out value="${j}" /></h1>
	</c:forEach>
	
	<!-- 6. re direct -->
	<%-- <c:redirect url="https://www.netflix.com/in/"></c:redirect> --%>
</body>
</html>