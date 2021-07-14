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
	padding-left: 15px;
	padding-right: 15px;
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
	<div class="top">
		<div class="contain-search">
			<form action="SearchUnitServlet" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="search-btn" type="submit" name="btnSearch"
					value="Search">
			</form>
		</div>
	</div>
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
			</tr>
		</tfoot>
	</table>
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<h1>Danh sách đơn vị quản lý tuyến xe</h1>
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