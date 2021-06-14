<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<% 
String color = "pink"; 
String display = "none"; 
String display1 = "true"; 
String display2 = "visible"; 


%>
<style type="text/css">
.name{
color:<%=color%>;
display: <%=display2%>;
}
</style>
</head>
<body>
<div class="name">
<h1>Khánh</h1>
</div>
</body>
</html>