<%@page import="model.AccountDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập Quản lý hệ thống xe bus</title>
<style>
@import "flex";
.guess{
color: green;
}
.containerApp {
	margin-top: 100px;
	padding: 50px;
	width: 1200px;
	height: 700px;
	margin: auto;
	font-family: "Segoe UI";
	background: #ffff;
}

.containerApp .MainForm {
	background: #75b9e6;
	height: 500px;
	padding-top: 80px;
	border-radius: 0px 0px 10px 10px;
}

.containerApp .MainForm .NoiDungForm {
	background: #c3e4e4;
	width: 400px;
	height: 350px;
	margin: auto;
	border-radius: 10px;
}

.containerApp .overview {
	margin-top: 10px;
	display: space-around;
}

.errorText {
	font-size: 19px;
	margin-bottom: -30px;
	font-weight: bold;
	color: red;
}

.containerApp .overview .GiaoDien {
	flex: 1 1 40%;
	border: 1px solid #badcf2;
}

.containerApp .overview .DinhForm {
	padding-top: 7px;
	background: #badcf2;
	height: 40px;
	border-radius: 10px 10px 0px 0px;
}

.containerApp .overview .DinhForm h3 {
	padding-left: 30px;
	font-style: italic;
	margin-top: -3px;
	font-size: 30px;
}

.containerApp .overview .DinhForm .fontPhu {
	text-align: right;
	padding-right: 30px;
	/*     margin-top: -60px; */
	font-size: 20px;
}

.fontPhu {
	margin-top: -45px;
}

.containerApp .overview .DinhForm .fontPhu span {
	padding-left: 40px;
}

.containerApp .overview .DinhForm .fontPhu span.inDam {
	font-weight: bold;
}

.containerApp .MainForm .NoiDungForm input[type="submit"] {
	/*     background: #11605b; */
	color: white;
	font-size: 1.2em;
	padding: 2px;
	margin-bottom: 20px;
}

.containerApp .MainForm .NoiDungForm .tenForm {
	padding-top: 20px;
	height: 50px;
}

.containerApp .MainForm .NoiDungForm .tenForm .textdangnhap {
	display: flex;
	justify-content: center;
	padding: auto;
	font-size: 40px;
	margin-top: 5px;
}

.containerApp .MainForm .NoiDungForm .NoiDung {
	padding: 1px 30px 0px;
	margin-top: 30px;
}
/* .containerApp .MainForm .NoiDungForm .NoiDung .nguoidung {
    padding: 15px 80px 0px;
    margin-top: -12px;   
}
.containerApp .MainForm .NoiDungForm .NoiDung .pass {
    padding: 15px 80px 0px;
    margin-top: -12px;
    
} */
.containerApp .MainForm .NoiDungForm .NoiDung input[type="password"],
	.containerApp .MainForm .NoiDungForm .NoiDung input[type="text"] {
	outline: none;
	font-size: 1.2em;
	width: 100%;
	justify-content: center;
	color: #000;
	margin-top: -5px;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%
		AccountDetails accountDetails = (AccountDetails) session.getAttribute("user");
	String error = (String) session.getAttribute("Invalid");
	if (error == null || error == "") {
		error = "";
	}
	if (accountDetails != null) {
	%>
	<jsp:forward page="home.jsp"></jsp:forward>
	<%
		}
	%>
	<form action="home" method="post">
		<div class="containerApp">
			<div class="overview flex">
				<div class="GiaoDien">
					<div class="DinhForm flex j-between">
						<h3>QUẢN LÝ XE BUS</h3>
						<div class="fontPhu">
							<span class="inDam">Đăng nhập</span> <a href="./signup.jsp">
								<span>Đăng kí</span>
							</a>
						</div>
					</div>
					<div class="MainForm">
						<div class="NoiDungForm">
							<div class="tenForm">
								<h4 class="textdangnhap">ĐĂNG NHẬP</h4>
							</div>
							<br>
							<div class="errorText">
								<%=error%>
							</div>
							<div class="NoiDung">
								<p for="taikhoan">TÊN TÀI KHOẢN</p>
								<input name="userName" class="nguoidung" type="text" required="">
							</div>
							<div class="NoiDung">
								<p class="matkhau" for="taikhoan">MẬT KHẨU</p>
								<input name="Password" class="pass" type="password" required="">
							</div>
							<div style="margin-top: 30px;" class="submit NoiDung j-between">
								<input class="btn btn-primary btn-lg" type="submit"
									value="Đăng nhập"> 
							<a class="guess" href="./home.jsp">
									Vào nhanh không cần đăng nhập
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
	</form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>