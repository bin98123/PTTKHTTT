<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="favicon.ico">




<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">
.left-img {
	max-width: 170px;
	display: block;
	margin-left: auto;
	margin-right: auto;
	border-radius: 15px 15px;
}

.container111 {
	flex-direction: row;
	background-color: gray;
	flex-wrap: wrap;
}

.left {
	float: left;
	width: 35%;
	/* 	width: 28%; */
	margin-left: 0px;
}

.right {
	width: 65%;
	float: right;
	/* 	background-color: blue; */
}

.bnt-edit {
	margin-bottom: 15px;
	/*margin-right: 12px;
*/
	flex-direction: column;
}

.bnt-edit {
	margin-top: 15px;
}

/* .contain_name_in { */
/* 	margin-top: 18px; */
/* 	margin-left: 16px; */
/* } */
.bnt-edit {
	margin-left: 0px;
	/*margin-right: 20px;

   */
	font-size: 28px;
	color: gray;
	background-color: #3EDCF7;
}

input.name_in::-webkit-input-placeholder {
	text-align: left;
	/* margin-left: 250px; */
	/* line-height: 3;/*chiều cao trong khung*/
}

input::-webkit-input-placeholder {
	font-size: 28px;
	text-align: left;
	width: 438px;
	/* line-height: 3;/*chiều cao trong khung*/
}

.contain_bnt_edit {
	margin-left: 12px;
}

.update {
	align-items: center;
	color: black;
	margin-left: 40px;
	border-radius: 15px 15px;
	border-color: darkcyan;
	color: black;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	text-decoration: none;
	padding: 10px 12px;
}

.update:hover {
	color: blue;
	border-color: blue;
}

.cancel {
	color: black;
	border-color: darkcyan;
	margin-left: 40px;
	border-radius: 15px 15px;
	border-color: darkcyan;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	text-decoration: none;
	padding: 10px 12px;
}

.cancel:hover {
	border-color: blue;
	color: blue;
}

.name_in {
	width: 47%;
	height: 47px;
	border-radius: 10px 10px;
	font-size: 28px;
}

.bnt-edit {
	justify-content: center; /* center the content horizontally */
	align-items: center; /* center the content vertically */
	text-align: center;
}

.address_in, .phoneNumber_in, .email_in, .name_in {
	width: 95%;
	height: 47px;
	margin: 15px;
	flex-direction: column;
	border-radius: 10px 10px;
	font-size: 28px;
}

.top-info {
	height: 20px;
	background-color: darkcyan;
}

.right-title {
	height: 50px;
	display: flex;
}

.right-title-sub {
	/*
  margin-right: 220px;
  margin-left: 50px;
  */
	width: 85%;
	flex-direction: column;
}

.right-change-bnt {
	font-size: 20px;
	line-height: 1;
	color: black;
	border-color: black;
	border-radius: 15px 15px;
	margin-right: 10px;
	border-color: black;
	border-radius: 15px 15px;
	background-color: darkred;
}

.right-change-bnt:hover {
	background-color: darkred;
	border-color: darkgray;
	color: darkgray;
	border-radius: 15px 15px;
	cursor: pointer;
}

.contain_right-content-left {
	width: 30%;
	margin-left: 35px;
}

.right-content-left {
	flex-direction: column;
	width: fit-content;
	font-size: 20px;
	font-weight: bold;
}

.email {
	margin-top: 0px;
}

.email_info {
	
}

.right-content-left {
	font-size: 28px;
}

.contain_right-content-right {
	width: 70%;
}

.right-content-right {
	flex-direction: column;
	width: fit-content;
	font-size: 28px;
}

.contain_right-content-left {
	
}

.right-content {
	margin-top: 30px;
	display: flex;
}

.form-control-file {
	margin-left: 100px;
	width: 60%;
	align-items: center;
	display: block;
	margin-left: auto;
	margin-right: auto;
}
}
</style>
<title>Trang thông tin cá nhân</title>
</head>
<%
	AccountDetails accountDetails1 = (AccountDetails) session.getAttribute("user");
if (accountDetails1 != null) {
	// 	session.setMaxInactiveInterval(1800);
%>
<body style="background-color: darkcyan">
	<div class="container111">
		<div class="top-info"></div>
		<!-- <div class="contain_left">-->
		<form action="EditAccount" method="post">
			<div class="left">
				<!-- 			<a for="exampleFormControlFile1"> <img src='./images/demo.png' -->
				<!-- 				title="ảnh demo avatar" alt="demo avatar" class="left-img"> -->
				<!-- 			</a> <input type="file" class="form-control-file" -->
				<!-- 				id="exampleFormControlFile"> -->
				<div class="left-content">
					<!-- 				<div class="contain_name_in"> -->
					<input placeholder="Họ và tên" class="name_in" name="name_in"
						type="text">
					<!-- 					 <input -->
					<!-- 						placeholder="Tên" class="name_in" type="text"> -->
					<!-- 				</div> -->
					<input placeholder="Ngày sinh: dd/mm/yyyy" class="address_in"
						name="address_in" type="text"> <input
						placeholder="Email: name@example.com" class="email_in"
						name="email_in" type="text"> <input
						placeholder="Số điện thoại" class="phoneNumber_in"
						name="phoneNumber_in" type="text">
					<div class="contain_bnt_edit">
						<button class="btn btn-primary btn-lg bnt-edit update"
							type="submit">Cập nhật</button>
						<button class="btn btn-primary btn-lg bnt-edit cancel"
							type="reset">Hủy bỏ</button>
					</div>
				</div>
			</div>
		</form>

		<div class="right">
			<div class="right-title">
				<h2 class="right-title-sub">Thông tin cá nhân</h2>
				<button class="btn btn-danger right-change-bnt" type="button"
					onclick="window.location.href='./changePassword.jsp'">Thay
					đổi mật khẩu</button>
			</div>
			<div class="right-content">
				<div class="contain_right-content-left">
					<p class="right-content-left firstName">Họ và tên</p>
					<p class="right-content-left address">Ngày sinh</p>
					<p class="right-content-left email">Email</p>
					<p class="right-content-left phoneNumber">Số điện thoại</p>
				</div>
				<div class="contain_right-content-right">
					<p class="right-content-right"><%=accountDetails1.getFullName()%></p>
					<p class="right-content-right"><%=accountDetails1.getBirthday()%></p>
					<p class="right-content-right email_info"><%=accountDetails1.getEmail()%></p>
					<p class="right-content-right"><%=accountDetails1.getPhoneNumber()%></p>


				</div>
			</div>
		</div>
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

	</div>
	<%
		} else {
	%>
	<jsp:forward page="findPath.jsp"></jsp:forward>
	<%
		}
	%>
</body>
</html>
