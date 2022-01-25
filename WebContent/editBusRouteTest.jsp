<%@page import="dao.UnitDAO"%>
<%@page import="dao.RouteDAO"%>
<%@page import="controller.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
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

<%
	String id = (String) session.getAttribute("idRoute");
%>
<title>Chỉnh Sửa Tuyến Xe có ID: <%=id%></title>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">

				<h2 class="myclass" style="color: blue;">
					Chỉnh Sửa Tuyến Xe có ID:
					<%=id%></h2>
				<form action="Route" method="post">
					<div class="form-group">
						<label>Mã Tuyến</label>
						<!-- 						<input list="dess" name="des" class="" -->
						<!-- 							type="text" required="" id="des" placeholder="bus0XX"> -->
						<!-- 						<datalist id="dess"> -->
						<select name="des" id="des">
							<%
								List<BusRouteDetails> busRouteList = new ArrayList<BusRouteDetails>();
							RouteDAO c1 = new RouteDAO();
							busRouteList = c1.getRouteName();
							for (BusRouteDetails bus : busRouteList) {
							%>
							<option value="<%=bus.getRouteName()%>"><%=bus.getRouteName()%></option>
							<%
								}
							%>

						</select>
					</div>
					<div class="form-group">
						<label>Tên Đơn Vị</label>
						<!-- 						<input list="dess" name="des" class="" -->
						<!-- 							type="text" required="" id="des" placeholder="bus0XX"> -->
						<!-- 						<datalist id="dess"> -->
						<select name="des0" id="des0">
							<%
								List<BusUnitManagerDetails> busList = new ArrayList<BusUnitManagerDetails>();
							UnitDAO c = new UnitDAO();
							busList = c.getUnitID();
							for (BusUnitManagerDetails bus : busList) {
							%>
							<option value="<%=bus.getUnitID()%>"><%=bus.getUnitID()%></option>
							<%
								}
							%>
						</select>
					</div>

					<div class="form-group">
						<label>Thời Gian Bắt Đâu</label> <input type="text"
							class="form-control" name="start" placeholder="XXhXX">
					</div>
					<div class="form-group">
						<label>Thời Gian Kết Thúc</label> <input type="text"
							class="form-control" name="end" placeholder="XXhXX">
					</div>
					<div class="form-group">
						<label>Thời Gian Giản Cách</label> <input type="text"
							class="form-control" name="break" placeholder="Nhập số">
					</div>
					<div class="form-group">
						<label>Lộ Trình Lượt Đi</label> <input type="text"
							class="form-control" name="go" placeholder="Nhập trạm bắt đầu">
					</div>
					<div class="form-group">
						<label>Lộ Trình Lượt Về</label> <input type="text"
							class="form-control" name="back" placeholder="Nhập trạm kết thúc">
					</div>
					<div class="form-group">
						<label>Loại Tuyến</label> <input type="text" class="form-control"
							name="kind" placeholder="Nhập loại tuyến">
					</div>


					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='./ManagerRoute.jsp'">Return</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>