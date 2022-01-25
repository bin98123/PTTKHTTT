<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
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
	float: right;		
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
	String value = (String) session.getAttribute("valueStop");
if (value == null) {
	value = "";
}
if (value != "") {
%>
<script>
		alert("Không Thể Xóa Trạm Dừng Đang Được Sử Dụng!");
	
		</script>
<%
	}
session.removeAttribute("valueStop");
%>
</head>
<body>
	<%
		List<ChuyenDetails> chuyen = (List<ChuyenDetails>) request.getAttribute("manalist1");
	String none = (String) request.getAttribute("none");
	Chuyen c = new Chuyen();
	List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
	chuyens = c.getChuyens();
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
			<form action="ManagerSearchServlet" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="btn btn-sm btn-primary search-btn" type="submit"
					name="btnSearch" value="Search">
			</form>
		</div>
	</div>
	<h1 id="default" style="display: <%=none%>;">Danh sách Trạm Dừng</h1>
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

				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (ChuyenDetails e : chuyen) {
			// 				if (e.getID() > 0) {
		%>
		<tbody>
			<tr>
				<td style="text-align: left"><%=e.getID()%></td>
				<td style="text-align: left"><%=e.getSTT()%></td>

				<td style="text-align: left"><%=e.getTemTram()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=edit&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=delete&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>
			</tr>

			<%
				// 				}
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>
			</tr>
		</tfoot>
	</table>
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<div class="containt-top">
		<div class="top-content">
			<h1>Danh Sách Trạm Dừng Lượt Đi</h1>
		</div>
		<div class="bnt-add">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./addBusStop.jsp'">Thêm</button>
		</div>
		<div class="bnt-rollback">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./ManagerBusStop?submit=rollback'">Hoàn
				tác</button>
		</div>
		<div class="bnt-export">
			<a class="btn btn-sm btn-primary" href="Download_BusStop.jsp"> <i
				class="fas fa-file-upload"></i> <span>Xuất file Excel</span>
			</a>
		</div>
		<div class="bnt-import">
			<a class="btn btn-sm btn-primary" href="Upload_BusStop.jsp"> <i
				class="fas fa-file-upload"></i> <span>Nhập file Excel</span>
			</a>
		</div>
		<div class="bnt-deleteAll">
			<a class="btn btn-sm btn-danger"
				onclick="window.location.href='./ManagerBusStop?submit=deleteAll'">
				<i class="fa fa-trash-o"></i> <span>Xóa hết</span>
			</a>
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

				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (ChuyenDetails e : chuyens) {
			if (e.getID() > 0) {
		%>
		<tbody>
			<tr>
				<td style="text-align: left"><%=e.getID()%></td>
				<td style="text-align: left"><%=e.getSTT()%></td>

				<td style="text-align: left"><%=e.getTemTram()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=edit&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=delete&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>
			</tr>

			<%
				}
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</tfoot>
	</table>
	<div class="containt-top">
		<div class="top-content">
			<h1>Danh Sách Trạm Dừng Lượt Về</h1>
		</div>
		<div class="bnt-add">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./addBusStop.jsp'">Thêm</button>
		</div>
		<div class="bnt-rollback">
			<button type="button" class="btn btn-sm btn-primary"
				onclick="window.location.href='./ManagerBusStop?submit=rollback'">Hoàn
				tác</button>
		</div>
		<div class="bnt-export">
			<a class="btn btn-sm btn-primary" href="Download_BusStop.jsp"> <i
				class="fas fa-file-upload"></i> <span>Xuất file Excel</span>
			</a>
		</div>
		<div class="bnt-import">
			<a class="btn btn-sm btn-primary" href="Upload_BusStop.jsp"> <i
				class="fas fa-file-upload"></i> <span>Nhập file Excel</span>
			</a>
		</div>
		<div class="bnt-deleteAll">
			<a class="btn btn-sm btn-danger"
				onclick="window.location.href='./ManagerBusStop?submit=deleteAll'">
				<i class="fa fa-trash-o"></i> <span>Xóa hết</span>
			</a>
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

				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</thead>
		<%
			for (ChuyenDetails e : chuyens) {
			if (e.getID() < 0) {
		%>
		<tbody>
			<tr>
				<td style="text-align: left"><%=Math.abs(e.getID())%></td>
				<td style="text-align: left"><%=e.getSTT()%></td>

				<td style="text-align: left"><%=e.getTemTram()%></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-info btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=edit&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-edit"></i>
					</button></td>
				<td style="text-align: center; line-height: inherit;"><button
						type="button" class="btn btn-danger btn-sm"
						onclick="window.location.href='./ManagerBusStop?submit=delete&unitID=<%=e.getID()%>&serial=<%=e.getSTT()%>'">
						<i class="fa fa-trash-o"></i>
					</button></td>
			</tr>

			<%
				}
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
				<th style="text-align: left">Sửa</th>
				<th style="text-align: left">Xóa</th>

			</tr>
		</tfoot>
	</table>
	<script type="text/javascript">
<!-- 	<script> -->
	document.getElementById("example").style.display= "<%=none%>"
				;
	document.getElementById("default").style.display="<%=none%>
		"
				;
		// 	document.getElementById("example").style.display="none";
	
				</script>

</body>
</html>