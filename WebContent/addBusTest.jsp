<%@page import="dao.RouteDAO"%>
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

				<h2 class="myclass" style="color: blue;">Thêm Xe Buýt</h2>
				<form action="Bus" method="post">
					<div class="form-group">
						<label>Mã xe</label> <input type="text" class="form-control"
							name="busID" placeholder="Nhập mã số xe">
					</div>
					<div class="form-group">
						<label>Mã số tuyến</label>
						<!-- 						<input list="dess" name="des" class="" -->
						<!-- 							type="text" required="" id="des" placeholder="bus0XX"> -->
						<!-- 						<datalist id="dess"> -->
						<select name="des" id="des">
							<%
								List<BusRouteDetails> busList = new ArrayList<BusRouteDetails>();
							RouteDAO c = new RouteDAO();
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
						<label>Biển số xe</label> <input type="text" class="form-control"
							name="license" placeholder="Nhập biển số xe">
					</div>
					<div class="form-group">
						<label>Loại xe</label> <input type="text" class="form-control"
							name="kind" placeholder="Nhập loại xe">
					</div>
					<div class="form-group">
						<label>Ngày sản xuất</label> <input type="text"
							class="form-control" name="manu"
							placeholder="Nhập ngày sản xuất: dd/mm/yyyy">
					</div>
					<div class="form-group">
						<label>Ngày bảo hành</label> <input type="text"
							class="form-control" name="gua"
							placeholder="Nhập ngày bảo hành: dd/mm/yyyy">
					</div>


					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='./ManagerBus.jsp'">Return</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>