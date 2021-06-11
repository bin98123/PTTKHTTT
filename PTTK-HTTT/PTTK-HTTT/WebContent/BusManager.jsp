<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
<%@ page import="controller.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
	padding-left: 15px;
	padding-right: 15px;
}
</style>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
	<%
	// List<ChuyenDetails> chuyen= (List<ChuyenDetails>)request.getAttribute("list");
	Chuyen c = new Chuyen();
	List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
	chuyens = c.getChuyens();
	%>
	<table class="table table-striped table-bordered mydatatable"
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
			</tr>
		</thead>
		<%
		for (ChuyenDetails e : chuyens) {
		%>
		<tbody>
			<tr>
				<td  style="text-align: left"><%=e.getID()%></td>
				<td style="text-align: left"><%=e.getSTT()%></td>

				<td style="text-align: left"><%=e.getTemTram()%></td>
			</tr>

			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th style="text-align: left">Mã số Chuyến</th>
				<th style="text-align: left">STT</th>
				<th style="text-align: left">Tên Trạm</th>
			</tr>
		</tfoot>
	</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	<script>
		$('.mydatatable').DataTable({

		});
		
	</script>
	<!-- 
<script type="text/javascript">$(document).ready( function () {
	  var table = $('#example').DataTable({
		    initComplete: function () {
		        this.api().columns().every(function () {
		            var column = this;
		            var select = $('<select><option value=""></option></select>')
		                .appendTo($(column.footer()).empty())
		                .on('change', function () {
		            var val = $.fn.dataTable.util.escapeRegex(
		                  $(this).val()
		              );
		             column
		                        .search(val ? '^' + val + '$' : '', true, false)
		                        .draw();
		            });
		 
		          column.data().unique().sort().each(function (d, j) {
		          select.append('<option value="'+d+'">' + d + '</option>');
		        });
		      });
		    }
		  
		  });
		} );</script>
		 -->
</body>
</html>