<%@page import="model.BusStopDetails"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<%String display = (String) session.getAttribute("none ");
if (display == null) {
	display = "none";

}%>
.example {
	display: <%=display%>;
}

.exampleDefault {
	display: <%=display%>;
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
		List<BusStopDetails> chuyen = (List<BusStopDetails>) request.getAttribute("list1");
	String none = (String) request.getAttribute("none");
	BusStopDAO c = new BusStopDAO();
	List<BusStopDetails> chuyens = new ArrayList<BusStopDetails>();
	chuyens = c.getChuyens();
	request.setAttribute("listBusStop", chuyens);
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
			<form action="SearchServlet" medthod="post">
				<input class="search-box" type="text" name="txtSearch" size="15px">
				<input class="btn btn-sm btn-primary search-btn" type="submit"
					name="btnSearch" value="Search">
			</form>
		</div>
	</div>
	<!-- 	<h1 id="exampleDefault"> -->
	<!-- 		<Danh Sách Trạm Dừng Tìm Được> -->
	<!-- 	</h1> -->
	<!-- 	<table class="table table-striped table-bordered table-list example" -->
	<!-- 		id="example" style="width: 100%"> -->
	<!-- 		<thead> -->
	<!-- 			<tr> -->
	<!-- 				
<!-- 	<th>Mã số Chuyến</th> -->
	<!-- 	<th>Tên trạm lượt đi</th> -->
	<!-- 	<th>Tên Trạm lượt về</th> -->
	<!-- 	<th>Tên Chuyến</th> -->
	<!-- 	 -->

	<!-- 				<th style="text-align: left">Mã số Chuyến</th> -->
	<!-- 				<th style="text-align: left">STT</th> -->
	<!-- 				<th style="text-align: left">Tên Trạm</th> -->
	<!-- 			</tr> -->
	<!-- 		</thead> -->
	<%-- 		<c:forEach items="${listBusStop}" var="li"> --%>
	<!-- 			<tr> -->
	<%-- 				<td style="text-align: left">${li.routeID}</td> --%>
	<%-- 				<td style="text-align: left">${li.serial}</td> --%>
	<%-- 				<td style="text-align: left">${li.nameBusStop}</td> --%>
	<!-- 			</tr> -->
	<%-- 						 </c:forEach> --%>
	<!-- 		</tbody> -->
	<!-- 			<tfoot> -->
	<!-- 	<tr> -->
	<!-- 		<th style="text-align: left">Mã số Chuyến</th> -->
	<!-- 		<th style="text-align: left">STT</th> -->
	<!-- 		<th style="text-align: left">Tên Trạm</th> -->
	<!-- 	</tr> -->
	<!-- 	</tfoot> -->
	<!-- 	</table> -->
	<!-- 	<table class="table1" style="width: 50%; display: none"> -->
	<h1>Danh Sách Trạm Dừng Lượt Đi</h1>
	<table class="table table-striped table-bordered table-list table1"
		style="width: 70%">
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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBusStop}" var="li">
				<c:if test="${li.routeID >=0}">
					<tr>
						<td style="text-align: left">${li.routeID}</td>
						<td style="text-align: left">${li.serial}</td>
						<td style="text-align: left">${li.nameBusStop}</td>
					</tr>
				</c:if>
						 </c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
			</tr>
		</tfoot>
	</table>
	<h1>Danh Sách Trạm Dừng Lượt Về</h1>
	<table class="table table-striped table-bordered table-list table1"
		style="width: 70%">
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
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${listBusStop}" var="li1">
				<c:if test="${li1.routeID <0}">
					<tr>
						<td style="text-align: left">${Math.abs(li1.routeID)}</td>
						<td style="text-align: left">${li1.serial}</td>
						<td style="text-align: left">${li1.nameBusStop}</td>
					</tr>
				</c:if>
						 </c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
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