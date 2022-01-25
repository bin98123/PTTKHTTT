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

	public List<ChuyenDetails> getChuyens() {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusStop ORDER BY routeID DESC,serial ASC");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
				chuyen.setID(rs.getInt("routeID"));
//				System.out.println(rs.getFloat("ID"));
				chuyen.setSTT(rs.getInt("serial"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
//				if (!chuyens.contains(chuyen)) {
					chuyens.add(chuyen);
//				}
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<BusDetails> getBuses() {
		List<BusDetails> result = new ArrayList<BusDetails>();
		List<BusDetails> chuyens = new ArrayList<BusDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus");
			while (rs.next()) {
				BusDetails chuyen = new BusDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setBusID(rs.getNString("BusID"));
				chuyen.setLicensePlate(rs.getNString("licensePlate"));
				chuyen.setKind(rs.getNString("kind"));
				chuyen.setManufactureDay(rs.getDate("ManufactureDay"));
				chuyen.setLateGuaranteeDay(rs.getDate("LateGuaranteeDay"));
				chuyen.setRouteID(rs.getInt("RouteID"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getS	tring("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<BusUnitManagerDetails> getBusesUnitManager() {
		List<BusUnitManagerDetails> result = new ArrayList<BusUnitManagerDetails>();
		List<BusUnitManagerDetails> chuyens = new ArrayList<BusUnitManagerDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusUnitManager");
			while (rs.next()) {
				BusUnitManagerDetails chuyen = new BusUnitManagerDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setUnitID(rs.getNString("unitID"));
				chuyen.setUnitName(rs.getNString("unitName"));
				chuyen.setPhoneNumber(rs.getNString("phoneNumber"));
				chuyen.setEmail(rs.getNString("EMAIL"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getS	tring("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<BusRouteDetails> getBusRoute() {
		List<BusRouteDetails> result = new ArrayList<BusRouteDetails>();
		List<BusRouteDetails> chuyens = new ArrayList<BusRouteDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusRoute");
			while (rs.next()) {
				BusRouteDetails chuyen = new BusRouteDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setRouteID(rs.getInt("routeID"));
				chuyen.setUnitID(rs.getNString("unitID"));
				chuyen.setRouteName(rs.getNString("routeName"));
				chuyen.setTimeStart(rs.getNString("timeStart"));
				chuyen.setTimeEnd(rs.getNString("timeEnd"));
				chuyen.setTimeBreak(rs.getDouble("timeBreak"));
				chuyen.setStartLocation(rs.getString("startLocation"));
				chuyen.setEndLocation(rs.getString("endLocation"));
				chuyen.setKindRoute(rs.getString("kindRoute"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getS	tring("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<DriverDetails> getDriver() {
		List<DriverDetails> result = new ArrayList<DriverDetails>();
		List<DriverDetails> chuyens = new ArrayList<DriverDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Driver");
			while (rs.next()) {
				DriverDetails chuyen = new DriverDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setDriverID(rs.getNString("DriverID"));
				chuyen.setFullName(rs.getNString("FullName"));
				chuyen.setBirthday(rs.getDate("Birthday"));
				chuyen.setMale(rs.getBoolean("Male"));
				chuyen.setAddress(rs.getNString("Address"));
				chuyen.setCountry(rs.getNString("Country"));
				chuyen.setDayBegin(rs.getDate("DayBegin"));
				chuyen.setSalary(rs.getInt("Salary"));
				chuyen.setDriverLicense(rs.getNString("DriverLicense"));
				chuyen.setBusID(rs.getNString("BusID"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getS	tring("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<ChuyenDetails> getTrams() {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct nameBusStop from BusStop");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getS	tring("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<String> getList() {
		List<String> result = new ArrayList<String>();
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusStop");
			while (rs.next()) {
//				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
//				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("TenTram"));
//				System.out.println(rs.getNString("TenTram"));
				result.add(rs.getNString("nameBusStop"));
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
//			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}

		return result;

	}

	public List<BusDetails> getBusID() {
		List<BusDetails> result = new ArrayList<BusDetails>();
		List<BusDetails> chuyens = new ArrayList<BusDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct BusID from Bus");
			while (rs.next()) {
				BusDetails chuyen = new BusDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setBusID(rs.getNString("BusID"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<BusRouteDetails> getRouteName() {
		List<BusRouteDetails> result = new ArrayList<BusRouteDetails>();
		List<BusRouteDetails> chuyens = new ArrayList<BusRouteDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct routeName from BusRoute");
			while (rs.next()) {
				BusRouteDetails chuyen = new BusRouteDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setRouteName(rs.getString("routeName"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

	public List<BusUnitManagerDetails> getUnitID() {
		List<BusUnitManagerDetails> result = new ArrayList<BusUnitManagerDetails>();
		List<BusUnitManagerDetails> chuyens = new ArrayList<BusUnitManagerDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct unitID from BusUnitManager");
			while (rs.next()) {
				BusUnitManagerDetails chuyen = new BusUnitManagerDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setUnitID(rs.getString("unitID"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

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
		System.out.println(new Chuyen().getBusRoute());
//		System.out.println(new Chuyen().getBusRoute());
	}
//
//	@Override
//	public String toString() {
//		return "Chuyen [connectionUrl=" + connectionUrl + "]";
//	}
//	
}
