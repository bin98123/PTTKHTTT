<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="model.BusDetails"%>
<%@ page import="controller.*"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.swing.*"%>
<%@page import="javax.swing.JFileChooser"%>
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
	padding-left: 10px;
	padding-right: 10px;
}

.top {
	height: 30px;
	width: 50%;
}

.inputfile {
	width: 91px;
	float: right;
	margin-right: 30px;
	color: red;
}

#file-name {
	display: none;
	color: red;
}

.containt-top {
	display: flex;
}

.contain-search {
	/* 	display: table-row; */
	
}

.bnt-add {
	float: left;
	margin-left: 330px;
	/* width: 100px; */
}

.bnt-rollback {
	float: right;
}

.bnt-export {
	float: right;
}

.bnt-import {
	float: right;
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
	String value = (String) session.getAttribute("valueBus");
if (value == null) {
	value = "";
}
if (value != "") {
%>
<script>
		alert("Không Thể Xóa Xe Buýt Đang Được Sử Dụng!");
	
		</script>
<%
	}
session.removeAttribute("valueBus");
%>
</head>
<body>
	<%
		List<BusDetails> chuyen = (List<BusDetails>) request.getAttribute("listManaBus");
	String none = (String) request.getAttribute("none");
	BusDAO c = new BusDAO();
	List<BusDetails> chuyens = new ArrayList<BusDetails>();
	chuyens = c.getBusesList();
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
			<form action="ManagerSearchBusServlet" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="btn btn-sm btn-primary search-btn" type="submit"
					name="btnSearch" value="Search">
			</form>
		</div>
	</div>
	<h1 id="default" style="display: <%=none%>;">Danh sách Xe Buýt</h1>
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

				<th style="text-align: left">Mã xe</th>
				<th style="text-align: left">Biển số xe</th>
				<th style="text-align: left">Loại xe</th>
				<th style="text-align: left">Ngày sản xuất</th>
				<th style="text-align: left">Ngày bảo hành</th>
				<th style="text-align: left">Mã tuyến</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (BusDetails e : chuyen) {
		%>
		<tbody>
			<tr>
				<td style="text-align: left"><%=e.getBusID()%></td>
				<td style="text-align: left"><%=e.getLicensePlate()%></td>
				<td style="text-align: left"><%=e.getKind()%></td>
				<td style="text-align: left"><%=e.getManufactureDay()%></td>
				<td style="text-align: left"><%=e.getLateGuaranteeDay()%></td>
				<td style="text-align: center;"><%=e.getRouteID()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerBus?submit=edit&unitID=<%=e.getBusID()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerBus?submit=delete&unitID=<%=e.getBusID()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>

			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã xe</th>
				<th style="text-align: left">Biển số xe</th>
				<th style="text-align: left">Loại xe</th>
				<th style="text-align: left">Ngày sản xuất</th>
				<th style="text-align: left">Ngày bảo hành</th>
				<th style="text-align: left">Mã tuyến</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</tfoot>
	</table>
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<div class="containt-top">
		<div class="top-content">
			<h1>Danh sách Xe Buýt</h1>
		</div>
		<div class="bnt-add">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./addBus.jsp'">Thêm</button>
		</div>
		<div class="bnt-rollback">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./ManagerBus?submit=rollback'">Hoàn
				tác</button>
		</div>
		<div class="bnt-export">
			<a class="btn btn-sm btn-primary" href="Download_Bus.jsp"> <i
				class="fas fa-file-download"></i> <span>Xuất file Excel</span>
			</a>
		</div>
		<div class="bnt-import">
			<a class="btn btn-sm btn-primary" href="Upload_Bus.jsp"> <i
				class="fas fa-file-upload"></i> <span>Nhập file Excel</span>
			</a>
		</div>
		<div class="bnt-deleteAll">
			<a class="btn btn-sm btn-danger"
				onclick="window.location.href='./ManagerBus?submit=deleteAll'">
				<i class="fa fa-trash-o"></i> <span>Xóa hết</span>
			</a>
		</div>
		<%
			// 				session.setAttribute("timesImp", "1");
		%>
		<!-- 		<div class="inputfile-box"> -->

		<!-- 			<label className="btn btn-info btn-lg"> <a -->
		<!-- 				class="btn btn-sm btn-primary"> <i class="fas fa-file-upload"></i> -->
		<!-- 					<span>Nhập file Excel</span> -->
		<!-- 			</a> <input id="valueTemp" type="file" style="display: none" -->
		<!-- 				/> -->
		<!-- 			</label> -->
		<!-- 		</div> -->

	</div>

	<table class="table table-striped table-bordered table-list table1"
		style="width: 100%">
		<thead>
			<tr>
				<!-- 
	<th>Mã số Chuyến</th>
	<th>Tên trạm lượt đi</th>
	<th>Tên Trạm lượt về</th>
	<th>Tên Chuyến</th>
	 -->

				<th style="text-align: left">Mã xe</th>
				<th style="text-align: left">Biển số xe</th>
				<th style="text-align: left">Loại xe</th>
				<th style="text-align: left">Ngày sản xuất</th>
				<th style="text-align: left">Ngày bảo hành</th>
				<th style="text-align: left">Mã tuyến</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>


			</tr>
		</thead>
		<%
			for (BusDetails e : chuyens) {
		%>
		<tbody>
			<tr>
				<td style="text-align: left"><%=e.getBusID()%></td>
				<td style="text-align: left"><%=e.getLicensePlate()%></td>
				<td style="text-align: left"><%=e.getKind()%></td>
				<td style="text-align: left"><%=e.getManufactureDay()%></td>
				<td style="text-align: left"><%=e.getLateGuaranteeDay()%></td>
				<td style="text-align: center;"><%=e.getRouteID()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerBus?submit=edit&unitID=<%=e.getBusID()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerBus?submit=delete&unitID=<%=e.getBusID()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>
			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã xe</th>
				<th style="text-align: left">Biển số xe</th>
				<th style="text-align: left">Loại xe</th>
				<th style="text-align: left">Ngày sản xuất</th>
				<th style="text-align: left">Ngày bảo hành</th>
				<th style="text-align: left">Mã tuyến</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>


			</tr>
		</tfoot>
	</table>
	<!-- 	<input class="box__file" type="file" name="files[]" id="file" -->
	<!-- 		data-multiple-caption="{count} files selected" multiple /> -->

	<script type="text/javascript">
<!-- 	<script> -->
	document.getElementById("example").style.display= "<%=none%>";
	document.getElementById("default").style.display= "<%=none%>

		";
		// 	document.getElementById("example").style.display="none";
	</script>
	<script type="text/javascript">
	
// 	document.getElementById('valueTemp').onchange = function () {
// // 		var cookieValue = document.getElementById('valueTemp');
// 		var cookieValue1 = document.getElementsByClass('inputfile').getAttribute('value');
// 		  alert('Selected file: ' + cookieValue1);
// 		};

</body>
</html>