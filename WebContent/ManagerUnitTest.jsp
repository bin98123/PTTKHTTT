<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>

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
.containt-top{
display: flex;
}
.contain-search {
/* 	display: table-row; */
}
.bnt-add{
float: right;
margin-left: 330px;
/* width: 100px; */
}
.bnt-rollback{
float: right;
margin-right: 80px;
}
.top-content{
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
		List<BusUnitManagerDetails> chuyen = (List<BusUnitManagerDetails>) request.getAttribute("listBusUnit");
	String none = (String) request.getAttribute("none");
	Chuyen c = new Chuyen();
	List<BusUnitManagerDetails> chuyens = new ArrayList<BusUnitManagerDetails>();
	chuyens = c.getBusesUnitManager();
	if (none == null || none == "") {
		none = "none";
	}
	if (chuyen == null) {
		chuyen = chuyens;
	}
	%>
	<%-- 	<%@ include file="test.jsp" %> --%>
	
	<h1 id="default" style="display: <%=none%>;">Danh sách tìm kiếm</h1>
	<table id="example" style="width: 100%;display: <%=none%>">
		<thead>
			<tr>
				<!-- 
	<th>Mã số Chuyến</th>
	<th>Tên trạm lượt đi</th>
	<th>Tên Trạm lượt về</th>
	<th>Tên Chuyến</th>
	 -->

				<th style="text-align: left">Mã đơn vị</th>
				<th style="text-align: left">Tên đơn vị</th>
				<th style="text-align: left">Số điện thoại</th>
				<th style="text-align: left">Email</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (BusUnitManagerDetails e : chuyen) {
		%>
		<tbody>
			<tr>
				<td style="text-align: center"><%=e.getUnitID()%></td>
				<td style="text-align: left"><%=e.getUnitName()%></td>
				<td style="text-align: left"><%=e.getPhoneNumber()%></td>
				<td style="text-align: left"><%=e.getEmail()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button"
						onclick="window.location.href='./ManagerUnit?submit=edit&unitID=<%=e.getUnitID()%>'">
					Sửa</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button"
						onclick="window.location.href='./ManagerUnit?submit=delete&unitID=<%=e.getUnitID()%>'">
					Xóa</button></td>



			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã đơn vị</th>
				<th style="text-align: left">Tên đơn vị</th>
				<th style="text-align: left">Số điện thoại</th>
				<th style="text-align: left">Email</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</tfoot>
	</table>
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<div class="containt-top"> <div class="top-content">
	<h1>Danh sách đơn vị quản lý</h1></div> <div class="bnt-add"><button>Thêm</button></div> <div class="bnt-rollback"><button type="button"
						onclick="window.location.href='./ManagerUnit?submit=rollback'">Hoàn tác</button></div></div>
	<table class="table1" style="width: 100%;">
		<thead>
			<tr>
				<!-- 
	<th>Mã số Chuyến</th>
	<th>Tên trạm lượt đi</th>
	<th>Tên Trạm lượt về</th>
	<th>Tên Chuyến</th>
	 -->
				<th style="text-align: left">Mã đơn vị</th>
				<th style="text-align: left">Tên đơn vị</th>
				<th style="text-align: left">Số điện thoại</th>
				<th style="text-align: left">Email</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</thead>
		<%
			for (BusUnitManagerDetails e : chuyens) {
		%>
		<tbody>
			<tr>
				<td style="text-align: center"><%=e.getUnitID()%></td>
				<td style="text-align: left"><%=e.getUnitName()%></td>
				<td style="text-align: left"><%=e.getPhoneNumber()%></td>
				<td style="text-align: left"><%=e.getEmail()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button"
						onclick="window.location.href='./ManagerUnit?submit=edit&unitID=<%=e.getUnitID()%>'">
					Sửa</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button"
						onclick="window.location.href='./ManagerUnit?submit=delete&unitID=<%=e.getUnitID()%>'">
					Xóa</button></td>

			</tr>

			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã đơn vị</th>
				<th style="text-align: left">Tên đơn vị</th>
				<th style="text-align: left">Số điện thoại</th>
				<th style="text-align: left">Email</th>
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