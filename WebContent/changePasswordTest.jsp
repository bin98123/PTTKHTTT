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
</style>
<meta charset="utf-8">
<title>Thay Đổi Mật Khẩu Tài Khoản</title>
</head>
<body>
	<form action="ChangePassword" method="post">
		<div class="contain_change_pass">
			<input placeholder="Nhập Mật Khẩu Hiện Tại" class="current_pass"
				name="current_pass" type="text"> <input
				placeholder="Nhập Mật Khẩu Mới" class="new_pass" name="new_pass"
				type="text"> <input placeholder="Xác Nhận Mật Khẩu Mới"
				class="new_pass_con" name="new_pass_con" type="text">
		</div>
		<button type="submit" class="btn btn-primary">Lưu</button>
	</form>
</body>
</html>