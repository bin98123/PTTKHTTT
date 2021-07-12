<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
h1{
color: red;
font-weight: bold;
font-style: italic;
}
</style>
</head>
<body>
	<%
		String error = (String) session.getAttribute("error");
	if (error == null) {
		error = "";
	}
	%>
	<h1><%=error%></h1>
	<h1>Blank</h1>
</body>
</html>