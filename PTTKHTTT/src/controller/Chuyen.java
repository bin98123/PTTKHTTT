package controller;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ChuyenDetails;
import model.BusDetails;
import model.BusUnitManagerDetails;

public class Chuyen {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

	public List<ChuyenDetails> getChuyens() {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusStop");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
				chuyen.setID(rs.getFloat("routeID"));
//				System.out.println(rs.getFloat("ID"));
				chuyen.setSTT(rs.getInt("serial"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("nameBusStop"));
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

	public static void main(String[] args) {
//		System.out.println(new Chuyen().getList().contains("Đại học Nông Lâm"));
//		System.out.println(new Chuyen().getBuses());
		System.out.println(new Chuyen().getBusesUnitManager());
//		System.out.println(new Chuyen().getChuyens());
	}
//
//	@Override
//	public String toString() {
//		return "Chuyen [connectionUrl=" + connectionUrl + "]";
//	}
//	
}
