<%@page import="controller.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.BusRouteDetails"%>
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

				<h2 class="myclass" style="color: blue;">Thêm Trạm Dừng</h2>
				<form action="BusStop" method="post">
					<div class="form-group">
						<label>Mã số tuyến</label>
						<!-- 						<input list="dess" name="des" class="" -->
						<!-- 							type="text" required="" id="des" placeholder="bus0XX"> -->
						<!-- 						<datalist id="dess"> -->
						<select name="des" id="des">
							<%
								List<BusRouteDetails> busList = new ArrayList<BusRouteDetails>();
							Chuyen c = new Chuyen();
							busList = c.getRouteName();
							for (BusRouteDetails bus : busList) {
							%>
							<option value="<%=bus.getRouteName()%>"><%=bus.getRouteName()%></option>
							<%
								}
							%>

						</select>
					</div>

					<div class="form-group">
						<label>STT</label> <input type="text" class="form-control"
							name="name" placeholder="Enter name">
					</div>
					<div class="form-group">
						<label>Tên Trạm</label> <input type="text" class="form-control"
							name="busStop" placeholder="Enter address">
					</div>

					<!-- 					<div class="form-group"> -->
					<!-- 						<label>Photo</label> <br /> <input type="file" -->
					<!-- 							class="form-control" name="photo" placeholder="Enter photo"> -->
					<!-- 					</div> -->
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='./ManagerBusStop.jsp'">Return</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>