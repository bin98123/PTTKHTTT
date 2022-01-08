<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.ChuyenDetails"%>
<%@ page import="model.BusDetails"%>
<%@ page import="controller.*"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.swing.*"%>
<%@page import="javax.swing.JFileChooser"%>
<!DOCTYPE html>
<html>
<%@page import="dao.*"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.swing.*"%>
<%@page import="javax.swing.JFileChooser"%>
<%
// 	String timesImp = (String) session.getAttribute("timesImpBus");
// if (timesImp.equals("1")) {
BusDAO dao = new BusDAO();
dao.selectFile();
// }
response.sendRedirect("./ManagerBus.jsp");
// session.sendRedirect("welcome.html");
// session.removeAttribute("timesImp");
%>
<%-- <jsp:forward page="./ManagerBus.jsp"></jsp:forward> --%>
</body>
</html>