<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.contain_change_pass {
	/* 	display: flex; */
	margin-top: 60px;
}

.current_pass {
	display: grid;
	grid-template-areas: "siva";
	grid-auto-rows: auto;
	margin-bottom: 20px;
}

.new_pass {
	display: grid;
	grid-template-areas: "siva";
	grid-auto-rows: auto;
	margin-bottom: 20px;
}

.new_pass_con {
	margin-bottom: 20px;
}

<%String color = (String) session.getAttribute("errorChangePassColor ");
if (color == null) {
	color = "black";

}%>
h4 {
	color: <%=color%>;
}
</style>
<meta charset="utf-8">
<title>Thay Đổi Mật Khẩu Tài Khoản</title>
<%
	String error = (String) session.getAttribute("errorChangePass111");
if (error == null) {
	error = "";
}
%>
</head>
<body>
	<form action="ChangePassword" method="post">
		<h4>
			<%=error%>
		</h4session.removeAttribute("errorChangePass111");
			session.removeAttribute("errorChangePassColor");");
		%>
		<div class="contain_change_pass">
			<input placeholder="Nhập Mật Khẩu Hiện Tại" class="current_pass"
				name="current_pass" type="password" required="required"> <input
				placeholder="Nhập Mật Khẩu Mới" class="new_pass" name="new_pass"
				type="password" required="required"> <input
				placeholder="Xác Nhận Mật Khẩu Mới" class="new_pass_con"
				name="new_pass_con" type="password" required="required">
		</div>
		<button type="submit" class="btn btn-primary">Lưu</button>
		<button type="button" class="btn btn-danger"
			onclick="window.location.href='./homeTest.jsp'">Return</button>
	</form>
</body>
</html>