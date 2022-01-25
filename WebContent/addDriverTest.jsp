<%@page import="dao.BusDAO"%>
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

				<h2 class="myclass" style="color: blue;">Thêm Tài Xế</h2>
				<form action="Driver" method="post">
					<div class="form-group">
						<label>Mã tài xế</label> <input type="text" class="form-control"
							name="id" placeholder="Nhập id">
					</div>
					<div class="form-group">
						<label>Họ và tên</label> <input type="text" class="form-control"
							name="name" placeholder="Nhập họ tên">
					</div>
					<div class="form-group">
						<label>Ngày sinh</label> <input type="text" class="form-control"
							name="birthday" placeholder="dd/mm/yyyy">
					</div>
					<div class="form-group">
						<label class="container">Nam <input type="checkbox"
							name="male" checked><span class="checkmark"></span>
						</label>
						<!-- 						<label class="container">Male <input type="checkbox" -->
						<!-- 							 name="male" value="Nam" checked="checked"> <span -->
						<!-- 							class="checkmark"></span> -->
						<!-- 						</label> -->
					</div>
					<div class="form-group">
						<label>Địa chỉ</label> <input type="text" class="form-control"
							name="address" placeholder="Nhập địa chỉ">
					</div>
					<div class="form-group">
						<label>Quê quán</label> <input type="text" class="form-control"
							name="country" placeholder="Nhập quê quán">
					</div>
					<div class="form-group">
						<label>Ngày bắt đầu hợp đồng</label> <input type="text"
							class="form-control" name="dayBegin" placeholder="dd/mm/yyyy">
					</div>
					<div class="form-group">
						<label>Lương</label> <input type="text" class="form-control"
							name="salary" placeholder="Nhập lương tài xế">
					</div>
					<div class="form-group">
						<label>Bằng lái</label> <input type="text" class="form-control"
							name="license" placeholder="Nhập bằng lái xe">
					</div>
					<div class="form-group">
						<label>Mã xe</label>
						<!-- 						<input list="dess" name="des" class="" -->
						<!-- 							type="text" required="" id="des" placeholder="bus0XX"> -->
						<!-- 						<datalist id="dess"> -->
						<select name="des" id="des">
							<%
								List<BusDetails> busList = new ArrayList<BusDetails>();
							BusDAO c = new BusDAO();
							busList = c.getBusID();
							for (BusDetails bus : busList) {
							%>
							<option value="<%=bus.getBusID()%>"><%=bus.getBusID()%></option>
							<%
								}
							%>


						</select>
					</div>

					<!-- 					<div class="form-group"> -->
					<!-- 						<label>Photo</label> <br /> <input type="file" -->
					<!-- 							class="form-control" name="photo" placeholder="Enter photo"> -->
					<!-- 					</div> -->
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='./ManagerDriver.jsp'">Return</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>