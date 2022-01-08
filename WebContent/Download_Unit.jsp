<%@page import="dao.UnitDAO"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%><%@page
	import="java.io.*"%>
<%
	UnitDAO dao = new UnitDAO();
HSSFWorkbook wb = dao.getExportExel();
// write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte[] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=BusUnit.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
%>