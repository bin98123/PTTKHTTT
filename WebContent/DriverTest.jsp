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

.contain-search {
	float: right;
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

</head>
<body>
	<%
		List<DriverDetails> chuyen = (List<DriverDetails>) request.getAttribute("listDriver");
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
			<form action="SearchDriver" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="btn btn-sm btn-primary search-btn" type="submit"
					name="btnSearch" value="Search">
			</form>
		</div>
	</div>
	<h1 id="default" style="display: <%=none%>;">Danh sách tìm kiếm</h1>
	<table class="table table-striped table-bordered table-list example"
		id="example" style="width: 100%;display: <%=none%>">
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
				<td style="text-align: left"><%=e.getCountry()%></td>
				<td style="text-align: center"><%=e.getDayBegin()%></td>
				<td style="text-align: left"><%=e.getSalary()%></td>
				<td style="text-align: left"><%=e.getDriverLicense()%></td>
				<td style="text-align: left"><%=e.getBusID()%></td>

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
			</tr>
		</tfoot>
	</table>
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<h1>Danh sách tài xế</h1>
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
				<td style="text-align: left"><%=e.getCountry()%></td>
				<td style="text-align: center"><%=e.getDayBegin()%></td>
				<td style="text-align: left"><%=e.getSalary()%></td>
				<td style="text-align: left"><%=e.getDriverLicense()%></td>
				<td style="text-align: left"><%=e.getBusID()%></td>
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