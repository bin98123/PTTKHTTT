<%@page import="dao.BusDAO"%>
<%@page import="controller.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.BusDetails"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Nhập Tài Xế</title>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">

				<h2 class="myclass" style="color: blue;">Bus Driver</h2>
				<form action="#" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label>ID</label> <input type="text" class="form-control"
							name="id" placeholder="Enter id">
					</div>
					<div class="form-group">
						<label>Full Name</label> <input type="text" class="form-control"
							name="name" placeholder="Enter name">
					</div>
					<div class="form-group">
						<label>Birthday</label> <input type="text" class="form-control"
							name="birthday" placeholder="dd/mm/yyyy">
					</div>
					<div class="form-group">
						<label class="container">Male <input type="checkbox"
							checked="checked"> <span class="checkmark"></span>
						</label>
					</div>
					<div class="form-group">
						<label>Address</label> <input type="text" class="form-control"
							name="address" placeholder="Enter address">
					</div>
					<div class="form-group">
						<label>Country</label> <input type="text" class="form-control"
							name="country" placeholder="Enter country">
					</div>
					<div class="form-group">
						<label>Day Begin</label> <input type="text" class="form-control"
							name="dayBegin" placeholder="dd/mm/yyyy">
					</div>
					<div class="form-group">
						<label>Salary</label> <input type="text" class="form-control"
							name="salary" placeholder="Enter salary">
					</div>
					<div class="form-group">
						<label>Driver License</label> <input type="text"
							class="form-control" name="name" placeholder="Enter license">
					</div>
					<div class="form-group">
						<label>Bus ID</label> <input list="dess" name="des" class=""
							type="text" required="" id="des" placeholder="bus0XX">
						<datalist id="dess">
							<%
								List<BusDetails> busList = new ArrayList<BusDetails>();
							BusDAO c = new BusDAO();
							busList = c.getBusID();
							for (BusDetails bus : busList) {
							%>
							<option value="<%=bus.getBusID()%>">
								<%
									}
								%>
							
						</datalist>
					</div>

					<div class="form-group">
						<label>Photo</label> <br /> <input type="file"
							class="form-control" name="photo" placeholder="Enter photo">
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>