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
	<div class="contain-info1">
		<!-- 	style="flex-direction: row; background-color: yellow;flex-wrap: wrap;display: flex;"> -->
		<div class="left-info1" style="float: left; height: 100%;">
			<%@include file="findPath.jsp"%>
		</div>
	</div>
</body>
</html>
