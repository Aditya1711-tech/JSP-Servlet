<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is page two</h1>
	
	<%
	out.println("Wait....redirecting....");	
	Thread.sleep(2000);
	
	// Redirection to some jsp page
	response.sendRedirect("Page3.jsp");
	
	/* // Redirection to an external source
	response.sendRedirect("https://www.netflix.com/in/"); */
	
	%>
</body>
</html>