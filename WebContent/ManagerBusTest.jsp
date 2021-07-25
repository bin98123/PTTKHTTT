<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
<%@ page import="model.BusDetails"%>
<%@ page import="controller.*"%>
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

.containt-top {
	display: flex;
}

.contain-search {
	/* 	display: table-row; */
	
}

.bnt-add {
	float: right;
	margin-left: 330px;
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

</head>
<body>
	<%
		List<BusDetails> chuyen = (List<BusDetails>) request.getAttribute("listBus");
	String none = (String) request.getAttribute("none");
	Chuyen c = new Chuyen();
	List<BusDetails> chuyens = new ArrayList<BusDetails>();
	chuyens = c.getBuses();
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
			<form action="SearchBus" medthod="post">
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
	<script type="text/javascript">
<!-- 	<script> -->
	document.getElementById("example").style.display= "<%=none%>";
	document.getElementById("default").style.display= "<%=none%>
		";
		// 	document.getElementById("example").style.display="none";
	</script>
</body>
</html>