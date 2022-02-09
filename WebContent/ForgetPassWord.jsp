<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="icon" href="./img/bus-icon.png">
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

<%
String color = (String) session.getAttribute( "errorForgetPassColor ") ;
if (color == null) {color = "black";
	
}

%>
h5 {
	color: <%=color%>;
}
</style>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Quên Mật Khẩu</title>
</head>
<%
	String error = (String) session.getAttribute("errorForgetPass");
if (error == null) {
	error = "";

}
%>
<body>
	<form action="ForgetPassword" method="post">
		<h4>Lấy Lại Mật Khẩu</h4>
		<%
			session.removeAttribute("errorForgetPass");
		session.removeAttribute("errorForgetPassColor");
		%>
		<h5><%=error%>
		</h5>

		<input placeholder="Địa Chỉ Email Của Bạn" class="new_pass"
			name="email" type="text" required="required" size="30">
		<button type="submit" class="btn btn-primary">Gửi yêu cầu lấy
			lại mật khẩu</button>
		<button type="button" class="btn btn-danger"
			onclick="window.location.href='./login.jsp'">Trở Về</button>
	</form>
</body>
</html>