<%@page import="controller.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.BusDetails"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Nhập Tài Xế</title>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">

				<h2 class="myclass" style="color: blue;">Thêm Đơn Vị Quản Lý</h2>
				<form action="Unit" method="post">
					<div class="form-group">
						<label>Mã đơn vị</label> <input type="text" class="form-control"
							name="id" placeholder="Enter id">
					</div>
					<div class="form-group">
						<label>Tên đơn vị</label> <input type="text" class="form-control"
							name="name" placeholder="Enter name">
					</div>
					<div class="form-group">
						<label>Số điện thoại</label> <input type="text"
							class="form-control" name="phoneNumber"
							placeholder="Enter phone number">
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email" placeholder="Enter email">
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='./ManagerUnit.jsp'">Return</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>