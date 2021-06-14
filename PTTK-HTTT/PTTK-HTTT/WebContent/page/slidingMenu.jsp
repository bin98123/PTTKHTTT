<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PHẦN MỀM QUẢN LÝ TUYẾN XE BUS</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	user-select: none;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

.sidebar {
	position: fixed;
	width: 250px;
	height: 100%;
	left: 0;
	background: black;
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
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<div class="left">
		<nav class="sidebar">
			<ul>
				<li><a href="#">Thông tin cá nhân</a></li>
				<li><a href="#" class="manager-bnt">Quản lý <span
						class="fas fa-caret-down first"></span>
				</a>
					<ul class="manager-show">
						<li><a href="./BusManager2.jsp">Quản lý Tuyến Xe</a></li>
						<li><a href="#">Quản lý Đơn vị</a></li>
						<li><a href="#">Quản lý tài xế</a></li>
						<li><a href="#">Quản lý nhân viên</a></li>
					</ul></li>
				<li><a href="#" class="search-bnt">Tra cứu <span
						class="fas fa-caret-down second"></span>

				</a>
					<ul class="search-show">
						<li><a href="#">Tra cứu Tuyến Xe</a></li>
						<li><a href="#">Tra cứu Đơn vị</a></li>
						<li><a href="#">Tra cứu tài xế</a></li>
						<li><a href="#">Tra cứu nhân viên</a></li>
					</ul></li>
				<li><a href="#">Thoát</a></li>
			</ul>
		</nav>


	</div>



	<div class="rightt"></div>
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