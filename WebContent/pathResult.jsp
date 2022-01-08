<%@page import="java.util.ArrayList"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="./img/bus-icon.png">
<title>Kết quả đường đi</title>
<style type="text/css">
td {
	color: darkblue;
}

table {
	margin-top: 30px;
	margin-left: 10px;
}
</style>
</head>
<body>
	<%
		// 		List<String> path1 = (List<String>) session.getAttribute("path1");
	List<String> path = (List<String>) session.getAttribute("path");
	List<String> path1 = new ArrayList<String>();
	path1.add(0, "");
	if (path == null) {
		path = path1;
	}
	if (path.size() > 0) {
		for (String e : path) {
	%>
	<table id="example" style="width: 100%">
		<thead>
			<tr>
				<td style="text-align: left"><%=e%></td>
				<%
					}
				}
				%>
			</tr>
		</thead>
	</table>
</body>
</html>