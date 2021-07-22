<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="icon" href="./img/bus-icon.png">
<style type="text/css">
.contain-info1 {
	display: flex;
}
</style>
</head>
<body>
	<div class="contain-path1">
		<!-- 	style="flex-direction: row; background-color: yellow;flex-wrap: wrap;display: flex;"> -->
		<div class="left-path1" style="float: left; height: 100%;">
			<%@include file="info.jsp"%>
		</div>
		<div class="right-path1"
			style="float: left; height: 100%; margin-left: 300px;">
			<jsp:include page="ManagerDriverTest.jsp" />
		</div>
	</div>
</body>
</html>
