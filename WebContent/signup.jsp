<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="./img/bus-icon.png">
<title>Đăng kí Quản lý hệ thống xe bus</title>
<!--      <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" -->
<!-- 	crossorigin="anonymous"> -->

<style type="text/css">
@import "flex";

.containerApp {
	margin-top: 100px;
	padding: 50px;
	width: 1200px;
	height: 700px;
	margin: auto;
	font-family: "Segoe UI";
	background: #ffff;
}

.guess {
	color: green;
	position: relative;
	top: -50px;
	left: 200px;
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
	height: 430px;
	margin: auto;
	margin-top: -45px;
	border-radius: 10px;
}

.containerApp .overview {
	margin-top: 10px;
	display: space-around;
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
	margin-top: -45px;
	font-size: 20px;
}

.containerApp .overview .DinhForm .fontPhu span {
	padding-left: 40px;
}

.containerApp .overview .DinhForm .fontPhu span.inDam {
	font-weight: bold;
}

.containerApp .MainForm .NoiDungForm .tenForm {
	padding-top: 20px;
	height: 50px;
}

.containerApp .MainForm .NoiDungForm .tenForm .textdangki {
	display: flex;
	justify-content: center;
	padding: auto;
	font-size: 40px;
	margin-top: 5px;
}

.textdangki {
	position: relative;
	top: -20px;
}

.error {
	margin-left: 20px;
	font-weight: bold;
}

.containerApp .MainForm .NoiDungForm input[type="submit"] {
	color: white;
	font-size: 1.2em;
	padding: 3px;
	margin-bottom: 20px;
}

.containerApp .MainForm .NoiDungForm .NoiDung {
	padding: 20px 20px 0px;
}

.containerApp .MainForm .NoiDungForm .NoiDung input[type="password"],
	.containerApp .MainForm .NoiDungForm .NoiDung input[type="text"] {
	outline: none;
	font-size: 1.2em;
	width: 100%;
	justify-content: center;
	color: #000;
}

.containerApp .MainForm .NoiDungForm .NDung {
	padding: 10px 20px 0px;
}

.containerApp .MainForm .NoiDungForm .NDung label {
	width: 40px;
}

.containerApp .MainForm .NoiDungForm .NDung input[type="text"],
	.containerApp .MainForm .NoiDungForm .NDung input[type="tel"],
	.containerApp .MainForm .NoiDungForm .NDung input[type="password"],
	.containerApp .MainForm .NoiDungForm .NDung input[type="email"] {
	outline: none;
	font-size: 1em;
	width: 70%;
	justify-content: center;
	color: #000;
	float: right;
}

.containerApp .MainForm .NoiDungForm .Ten {
	padding: 10px 20px 0px;
}

.containerApp .MainForm .NoiDungForm .Ten input[type="text"] {
	width: 40%;
	outline: none;
	font-size: 1em;
	justify-content: center;
	color: #000;
}

.containerApp .MainForm .NoiDungForm .Taikhoan {
	padding: 10px 20px 0px;
}

.containerApp .MainForm .NoiDungForm .Taikhoan label {
	font-size: 14px;
}

.containerApp .MainForm .NoiDungForm .Taikhoan input[type="text"],
	.containerApp .MainForm .NoiDungForm .Taikhoan input[type="tel"],
	.containerApp .MainForm .NoiDungForm .Taikhoan input[type="password"],
	.containerApp .MainForm .NoiDungForm .Taikhoan input[type="email"] {
	outline: none;
	font-size: 1em;
	width: 65%;
	justify-content: center;
	color: #000;
	float: right;
}
</style>


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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%
		String errorSignUp = (String) session.getAttribute("errorSignUp");
	if (errorSignUp == null) {
		errorSignUp = "";
	}
	session.removeAttribute("errorSignUp");
	%>
	<form action="SignUp" method="post">
		<div class="containerApp">
			<div class="overview flex">
				<div class="GiaoDien">
					<div class="DinhForm flex j-between">
						<h3>QUẢN LÝ XE BUS</h3>
						<div class="fontPhu">
							<a href="./login.jsp"><span>Đăng nhập</span></a> <span
								class="inDam">Đăng kí</span>

						</div>
					</div>
					<div class="MainForm">
						<div class="NoiDungForm dangky">
							<div class="tenForm ">
								<h4 class="textdangki">ĐĂNG KÍ</h4>
							</div>
							<div class="error"><%=errorSignUp%></div>
							<div class="Ten ">
								<label for="taikhoan">HỌ: </label> <input name="lastName"
									type="text" id="dangki" style="width: 60px;" required="">
								<label for="taikhoan" style="margin-left: 50px;">TÊN: </label> <input
									name="firstName" type="text" id="dangki" required=""
									style="float: right;">
							</div>
							<p class="NDung">
								<label for="taikhoan" style="width: 100px;">E-MAIL: </label> <input
									name="email" type="email" required="" id="dangki">
							</p>
							<p class="NDung">
								<label for="taikhoan">SĐT: </label> <input name="phoneNumber"
									type="tel" required="required" id="dangki">
							</p>
							<p class="NDung">
								NGÀY SINH: </label> <input name="birthday" type="text"
									required="required" id="dangki">
							</p>
							<p class="Taikhoan">
								<label>TÊN TÀI KHOẢN: </label> <input name="accountName"
									type="text" required="required" id="dangki">
							</p>
							<p class="Taikhoan">
								<label>MẬT KHẨU: </label> <input name="password" type="password"
									required="" id="dangki">
							</p>
							<div style="margin: auto; margin-top: -15px;"
								class="submit NoiDung j-between">
								<input class="btn btn-primary btn-lg" type="submit"
									value=" Đăng kí ">
							</div>
							<a class="guess NoiDung j-between" href="./ForgetPassWord.jsp">
								Quên mật khẩu? </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>