<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
td, th, table {
	border: 1px solid black;
	border-collapse: collapse;
}

td, th {
	padding-left: 5px;
	padding-right: 5px;
}

.top {
	height: 30px;
	width: 50%;
}

.containt-top {
	display: flex;
}

.contain-search {
	/* 	display: table-row; */
	
}

.bnt-add {
	float: right;
	margin-left: 580px;
	/* width: 100px; */
}

.bnt-rollback {
	float: right;
	margin-right: 80px;
}

.top-content {
	float: left;
	/* width: 100px; */
}
</style>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	-->
<meta charset="utf-8">
<title>Insert title here</title>
<%
	String value = (String) session.getAttribute("valueDriver");
if (value == null) {
	value = "";
}
if (value != "") {
%>
<script>
		alert("Không Thể Xóa Tài Xế Đang Được Sử Dụng!");
	
		</script>
<%
	}
session.removeAttribute("valueDriver");
%>
</head>
<body>
	<%
		List<DriverDetails> chuyen = (List<DriverDetails>) request.getAttribute("listManaDriver");
	String none = (String) request.getAttribute("none");
	Chuyen c = new Chuyen();
	List<DriverDetails> chuyens = new ArrayList<DriverDetails>();
	chuyens = c.getDriver();
	if (none == null || none == "") {
		none = "none";
	}
	if (chuyen == null) {
		chuyen = chuyens;
	}
	%>
	<%-- 	<%@ include file="test.jsp" %> --%>
	<div class="top">
		<div class="contain-search">
			<form action="ManagerSearchDriver" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="btn btn-sm btn-primary search-btn" type="submit"
					name="btnSearch" value="Search">
			</form>
		</div>
	</div>
	<h1 id="default" style="display: <%=none%>;">Danh sách tìm kiếm</h1>
	<table class="table table-striped table-bordered table-list example"
		id="example" style="width: 100%;display: <%=none%>">
		<%-- 	<table id="example" style="width: 100%;display: <%=none%>"> --%>
		<thead>
			<tr>
				<!-- 
	<th>Mã số Chuyến</th>
	<th>Tên trạm lượt đi</th>
	<th>Tên Trạm lượt về</th>
	<th>Tên Chuyến</th>
	 -->

				<th style="text-align: center">Mã tài xế</th>
				<th style="text-align: center">Họ và tên</th>
				<th style="text-align: center">Ngày sinh</th>
				<th style="text-align: center">Giới tính</th>
				<th style="text-align: center">Địa chỉ</th>
				<th style="text-align: center">Quê quán</th>
				<th style="text-align: center">Ngày bắt đầu hợp đồng</th>
				<th style="text-align: center">Lương</th>
				<th style="text-align: center">Bằng lái</th>
				<th style="text-align: center">Mã xe</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (DriverDetails e : chuyen) {
		%>
		<tbody>
			<tr>
				<td style="text-align: center"><%=e.getDriverID()%></td>
				<td style="text-align: left"><%=e.getFullName()%></td>
				<td style="text-align: left"><%=e.getBirthday()%></td>
				<%
					String male = null;
				if (e.getMale() == true) {
					male = "Nam";
				} else {

					male = "Nữ";
				}
				%>
				<td style="text-align: center"><%=male%></td>
				<td style="text-align: left"><%=e.getAddress()%></td>
				<td style="text-align: center"><%=e.getCountry()%></td>
				<td style="text-align: center"><%=e.getDayBegin()%></td>
				<td style="text-align: left"><%=e.getSalary()%></td>
				<td style="text-align: left"><%=e.getDriverLicense()%></td>
				<td style="text-align: left"><%=e.getBusID()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerDriver?submit=edit&unitID=<%=e.getDriverID()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerDriver?submit=delete&unitID=<%=e.getDriverID()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>

			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: center">Mã tài xế</th>
				<th style="text-align: center">Họ và tên</th>
				<th style="text-align: center">Ngày sinh</th>
				<th style="text-align: center">Giới tính</th>
				<th style="text-align: center">Địa chỉ</th>
				<th style="text-align: center">Quê quán</th>
				<th style="text-align: center">Ngày bắt đầu hợp đồng</th>
				<th style="text-align: center">Lương</th>
				<th style="text-align: center">Bằng lái</th>
				<th style="text-align: center">Mã xe</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</tfoot>
	</table>

	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<div class="containt-top">
		<div class="top-content">
			<h1>Danh sách tài xế</h1>
		</div>
		<div class="bnt-add">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./addDriver.jsp'">Thêm</button>
		</div>
		<div class="bnt-rollback">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./ManagerDriver?submit=rollback'">Hoàn
				tác</button>
		</div>
	</div>
	<!-- 	<table class="table1" style="width: 100%;"> -->
	<table class="table table-striped table-bordered table-list table1"
		style="width: 100%;">
		<thead>
			<tr>
				<!-- 
	<th>Mã số Chuyến</th>
	<th>Tên trạm lượt đi</th>
	<th>Tên Trạm lượt về</th>
	<th>Tên Chuyến</th>
	 -->
				<th style="text-align: center">Mã tài xế</th>
				<th style="text-align: center">Họ và tên</th>
				<th style="text-align: center">Ngày sinh</th>
				<th style="text-align: center">Giới tính</th>
				<th style="text-align: center">Địa chỉ</th>
				<th style="text-align: center">Quê quán</th>
				<th style="text-align: center">Ngày bắt đầu hợp đồng</th>
				<th style="text-align: center">Lương</th>
				<th style="text-align: center">Bằng lái</th>
				<th style="text-align: center">Mã xe</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</thead>
		<%
			for (DriverDetails e : chuyens) {
		%>
		<tbody>
			<tr>
				<td style="text-align: center"><%=e.getDriverID()%></td>
				<td style="text-align: left"><%=e.getFullName()%></td>
				<td style="text-align: left"><%=e.getBirthday()%></td>
				<%
					String male = null;
				if (e.getMale() == true) {
					male = "Nam";
				} else {

					male = "Nữ";
				}
				%>
				<td style="text-align: center"><%=male%></td>
				<td style="text-align: left"><%=e.getAddress()%></td>
				<td style="text-align: center"><%=e.getCountry()%></td>
				<td style="text-align: center"><%=e.getDayBegin()%></td>
				<td style="text-align: left"><%=e.getSalary()%></td>
				<td style="text-align: left"><%=e.getDriverLicense()%></td>
				<td style="text-align: left"><%=e.getBusID()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerDriver?submit=edit&unitID=<%=e.getDriverID()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerDriver?submit=delete&unitID=<%=e.getDriverID()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>
			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: center">Mã tài xế</th>
				<th style="text-align: center">Họ và tên</th>
				<th style="text-align: center">Ngày sinh</th>
				<th style="text-align: center">Giới tính</th>
				<th style="text-align: center">Địa chỉ</th>
				<th style="text-align: center">Quê quán</th>
				<th style="text-align: center">Ngày bắt đầu hợp đồng</th>
				<th style="text-align: center">Lương</th>
				<th style="text-align: center">Bằng lái</th>
				<th style="text-align: center">Mã xe</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</tfoot>
	</table>
	<script type="text/javascript">
<!-- 	<script> -->
	document.getElementById("example").style.display= "<%=none%>";
	document.getElementById("default").style.display= "<%=none%>
		";
		// 	document.getElementById("example").style.display="none";
	</script>
</body>
</html>