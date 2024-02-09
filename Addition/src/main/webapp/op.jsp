<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>JSP page</title>
</head>
<body>
	<h1></h1>
	<%
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		int nn1 = Integer.parseInt(n1);
		int nn2 = Integer.parseInt(n2);
		
		int division = nn1/nn2;
	%>
	
	<h1>Division is: <%= division %></h1>	
	
</body>
</html>