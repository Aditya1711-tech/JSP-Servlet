<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page errorPage="errorPage.jsp" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a:set var="name" value="Aditya"></a:set>
	<a:out value="${name}"></a:out>
	<br />
	<a:if test="${2 < 3}">
		<a:out value="${name}"></a:out>
		2nd time
	</a:if> 
	
	<%-- <%!
		int n1 = 200;
		int n2 = 0;
	%>
	
	<% 
		int division = n1/n2;
	%>
	
	<h3>Division of numbers <%= n1 %> by <%= n2 %> is <%= division %></h3>
	 --%>
</body>
</html>