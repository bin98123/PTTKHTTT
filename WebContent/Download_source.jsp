<%@page import="dao.AccountDao"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%><%@page
	import="java.io.*"%>
<%
	AccountDao accountDao = new AccountDao();
HSSFWorkbook wb = accountDao.getExportExel();
// write it as an excel attachment
ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte[] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=Accounts.xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
%>