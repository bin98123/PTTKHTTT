<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String male = (String) session.getAttribute("male");
	if (male == null) {
		male = "";
	}
	%>
	<h1><%=male%></h1>
</body>
</html>