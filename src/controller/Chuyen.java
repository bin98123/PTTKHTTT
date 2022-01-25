package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dao.ChuyenDetails;
import model.BusDetails;
import model.BusRouteDetails;
import model.BusUnitManagerDetails;
import model.DriverDetails;

public class Chuyen {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";


	// export excel file
	public HSSFWorkbook getExportExel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("routeID");
		cell = row.createCell(1);
		cell.setCellValue("serial");
		cell = row.createCell(2);
		cell.setCellValue("nameBusStop");

		try {
			int routeID;
			int serial;
			String nameBusStop;
			List<String> list = new ArrayList<String>();
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Chuyen;");
			int i = 1;
			while (rs.next()) {
				routeID = rs.getInt("routeID");
				serial = rs.getInt("serial");
				nameBusStop = rs.getString("nameBusStop");
				list.add(0, "" + routeID);
				list.add(1, "" + serial);
				list.add(2, "" + nameBusStop);

				row = sheet.createRow(i);

				for (int j = 0; j < list.size(); j++) {
					cell = row.createCell(j);
					cell.setCellValue(list.get(j));
				}
				list = new ArrayList<String>();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return wb;

	}

	public static void main(String[] args) {
//		System.out.println(new Chuyen().getList().contains("Đại học Nông Lâm"));
//		System.out.println(new Chuyen().getBuses());
//		System.out.println(new Chuyen().getBusesUnitManager());
//		System.out.println(new Chuyen().getBusRoute());
//		System.out.println(new Chuyen().getBusRoute());
	}
//
//	@Override
//	public String toString() {
//		return "Chuyen [connectionUrl=" + connectionUrl + "]";
//	}
//	
}
