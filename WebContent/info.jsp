<%@page import="dao.LoginDAO"%>
<%@page import="dao.AccountDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AccountDetails"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PHẦN MỀM QUẢN LÝ XE BUS</title>

<style type="text/css">
li {
	cursor: pointer;
}

* {
	margin: 0;
	padding: 0;
	user-select: none;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
	box-sizing: border-box;
}

.sidebar {
	position: fixed;
	width: 265px;
	height: 100%;
	left: 0;
	background: black;
	overflow-y: scroll;
}

nav ul {
	background: #1b1b1b;
	height: 100%;
	width: 100%;
	list-style: none;
}

nav ul li {
	line-height: 60px;
	border-bottom: 1px solid rgba(255, 255, 255, 0.1);
}

nav ul li a {
	color: white;
	text-decoration: none;
	font-size: 18px;
	padding-left: 40px;
	font-weight: 500;
	display: block;
	width: 100%;
	border-left: 3px solid transparent;
}

nav ul li a:hover {
	color: :cyan;
	background: #1e1e1e;
	border-left-color: cyan;
}

nav ul ul {
	display: none;
	position: static;
}

nav ul .manager-show.show {
	display: block;
}

nav ul .search-show.show1 {
	display: block;
}

nav ul ul {
	line-height: 42px;
	border-bottom: none;
}

nav ul ul li a {
	font-size: 17px;
	color: #e6e6e6;
	padding-left: 80px;
}
/*
*/
nav ul li a span {
	position: static;
	top: 50%;
	margin-left: 120px;
	transform: translateY(-50%);
	font-size: 22px;
	transition: transform 0.4s;
}

nav ul li a span.rotate {
	transform: translateY(-50%) rotate(-180deg);
}

body {
	background-color: white;
	/* 	overflow-y: scroll; */
}

.left1 {
	overflow-y: scroll;
	display: flex;
	float: left;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</head>
<body>

	<div class="left">
		<nav class="sidebar">
			<ul>
				<%
					AccountDetails accountDetails = (AccountDetails) session.getAttribute("user");
				if (accountDetails != null) {
					session.setMaxInactiveInterval(1800);
				%>
				<form id="info" action="homeTest.jsp" method="post">
					<li onclick="info.submit();"><input type="hidden"
						id="info-btn" value="info" /><a>Thông tin cá nhân</a></li>
				</form>
				<form id="statistic" action="Manager" method="get">
					<li onclick="statistic.submit();"><input name="action"
						type="hidden" id="statistic-btn" value="statistic" /><a>Thống
							kê</a></li>
				</form>
				<%
					} ;
				%>
				<form id="findPath" action="findPath.jsp" method="post">
					<li onclick="findPath.submit();"><input type="hidden"
						id="findPath-btn" value="findPath" /><a>Tìm đường</a></li>

					<%
						List<String> path1 = new ArrayList<String>();
					path1.add(0, "Không tìm được đường đi!!!");
					session.setAttribute("path1", path1);
					%>
				</form>
				<%
					AccountDao dao = new AccountDao();
				if (accountDetails != null) {
					//session.setMaxInactiveInterval(5);
					session.setMaxInactiveInterval(1800);
					dao.loginUser((String) session.getAttribute("currentUser"));
					System.out.println((String) session.getAttribute("currentUser"));
				} else if ((String) session.getAttribute("currentUser") == null) {
					session.invalidate();
					dao.logoutUser();
				}
				%>
				<%
					if (accountDetails != null) {
					session.setMaxInactiveInterval(1800);
				%>
				<li><a href="#" class="manager-bnt">Quản lý <span
						class="fas fa-caret-down first"></span>
				</a>
					<ul class="manager-show">
						<form id="managerBusRoute" action="Manager" method="get">
							<li onclick="managerBusRoute.submit();"><input name="action"
								type="hidden" id="manager-route-btn" value="manager-route" /><a>Quản
									lý Tuyến Xe</a></li>
						</form>
						<form id="managerUnit" action="Manager" method="get">
							<li onclick="managerUnit.submit();"><input name="action"
								type="hidden" id="manager-unit-btn" value="manager-unit" /><a>Quản
									lý Đơn vị</a></li>
						</form>
						<form id="managerDriver" action="Manager" method="get">
							<li onclick="managerDriver.submit();"><input name="action"
								type="hidden" id="manager-driver-btn" value="manager-driver" /><a>Quản
									lý Tài Xế</a></li>
						</form>
						<form id="managerBus" action="Manager" method="get">
							<li onclick="managerBus.submit();"><input name="action"
								type="hidden" id="manager-bus-btn" value="manager-bus" /><a>Quản
									lý Xe Buýt</a></li>
						</form>
						<form id="managerStop" action="Manager" method="get">
							<li onclick="managerStop.submit();"><input name="action"
								type="hidden" id="manager-stop-btn" value="manager-stop" /><a>Quản
									lý Trạm Dừng</a></li>
						</form>
					</ul></li>
				<%
					} ;
				%>
				<li><a href="#" class="search-bnt">Tra cứu <span
						class="fas fa-caret-down second"></span>

				</a>
					<ul class="search-show">
						<form id="myForm1" action="Manager" method="get">
							<li onclick="myForm1.submit();"><input name="action"
								type="hidden" id="search-bus-router-btn"
								value="search-bus-router" /><a>Tra cứu Tuyến Xe</a></li>
						</form>
						<form id="myForm2" action="Manager" method="get">
							<li onclick="myForm2.submit();"><input name="action"
								type="hidden" id="search-unit-btn" value="search-unit" /><a>Tra
									cứu Đơn vị</a></li>
						</form>
						<form id="myForm3" action="Manager" method="get">
							<li onclick="myForm3.submit();"><input name="action"
								type="hidden" id="search-bus-driver-btn"
								value="search-bus-driver" /><a>Tra cứu Tài Xế</a></li>
						</form>
						<form id="myForm4" action="Manager" method="get">
							<li onclick="myForm4.submit();"><input name="action"
								type="hidden" id="search-bus-btn" value="search-bus" /><a>Tra
									cứu Xe Buýt</a></li>
						</form>
						<form id="myForm5" action="Manager" method="get">
							<li onclick="myForm5.submit();"><input name="action"
								type="hidden" id="search-busStop-btn" value="search-busStop" /><a>Tra
									cứu Trạm Dừng</a></li>
						</form>
					</ul></li>
				<%
					if (accountDetails != null) {
				%>
				<form id="exit" action="Manager" method="get">
					<li onclick="exit.submit();"><input name="action" type="hidden"
						id="exit-btn" value="exit" /><a>Thoát</a></li>
				</form>
				<%
					} ;
				%>
				<%
					if (accountDetails == null) {
				%>
				<form id="exitGuess" action="index.jsp" method="post">
					<li onclick="exitGuess.submit();"><input name="action"
						type="hidden" id="exitGuess-btn" value="exitGuess" /><a>Thoát</a></li>
				</form>
				<%
					} ;
				%>
			</ul>
		</nav>
	</div>


	<div class="right1"></div>
	<script type="text/javascript">
		$('.manager-bnt').click(function() {
			$('nav ul .manager-show').toggleClass("show");
			$('nav ul .first').toggleClass("rotate");

		});
		$('.search-bnt').click(function() {
			$('nav ul .search-show').toggleClass("show1");
			$('nav ul .second').toggleClass("rotate");

		});
	</script>
</body>
</html>