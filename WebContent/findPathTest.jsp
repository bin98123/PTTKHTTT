<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tìm đường xe buýt</title>
<style type="text/css">
.findPath {
	margin-left: 30px;
	margin-top: 30px;
}

.btn {
	background-color: blue;
	color: white;
	border-color: white;
	border-radius: 15px 15px;
	border-color: darkcyan;
	cursor: pointer;
	padding: 2px 3px;
}

p {
	font-weight: bold;
}
.des{
outline: none;
}
.start{

outline: none;
}
</style>
<%
	String desInput = (String) session.getAttribute("desInput");
String startInput = (String) session.getAttribute("startInput");
if (desInput == null) {
	desInput = "";
}
if (startInput == null) {
	startInput = "";
}
%>
</head>
<body>
	<form action="find" method="post">
		<div class="findPath">
			<p class="start">- Điểm đi:</p>
			<input list="starts" name="start" class="start" type="text" required=""
				id="start" value="<%=startInput%>">
			<datalist id="starts">
				<%
					Chuyen c = new Chuyen();
				List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
				chuyens = c.getTrams();
				if (chuyens == null) {
					for (ChuyenDetails chuyen : chuyens) {
						chuyen.setTemTram("");
					}
				}
				for (ChuyenDetails chuyen : chuyens) {
				%>
				<option value="<%=chuyen.getTemTram()%>">
					<%
						}
					%>
				
			</datalist>
			<p class="des">- Điểm đến:</p>
			<input list="dess" name="des" class="des" type="text" required=""
				id="des" value="<%=desInput%>">
			<datalist id="dess">
				<%
					for (ChuyenDetails chuyen : chuyens) {
				%>
				<option value="<%=chuyen.getTemTram()%>">
					<%
						}
					%>
				
			</datalist>
			<div style="margin-top: 10px;" class="submit NoiDung j-between">
				<input class="btn" type="submit" value="Tìm đường" name="action">

			</div>
			<div class="co" style="display: flex;">
				<div class="result" style="float: left;">
					<%@include file="pathResult.jsp"%>
				</div>
				<div class="end-blocker" style="width: 3%; float: right;"></div>
			</div>
		</div>
	</form>
</body>
</html>