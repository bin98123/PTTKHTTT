package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BusDetails;
import model.BusUnitManagerDetails;

public class SearchDAO {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";

	public List<ChuyenDetails> getSearch(String txtSearch) {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusStop where routeID like N'%" + txtSearch
					+ "%' or SERIAL like N'%" + txtSearch + "%' or NAMEBUSSTOP like N'%" + txtSearch + "%'");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
				chuyen.setID(rs.getFloat("routeID"));
//				System.out.println(rs.getFloat("ID"));
				chuyen.setSTT(rs.getInt("SERIAL"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("NAMEBUSSTOP"));
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

	public List<BusDetails> getSearchBus(String txtSearch) {
		List<BusDetails> result = new ArrayList<BusDetails>();
		List<BusDetails> chuyens = new ArrayList<BusDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus where BusID like N'%" + txtSearch
					+ "%' or licensePlate like N'%" + txtSearch + "%' or kind like N'%" + txtSearch
					+ "%' or manufactureDay like N'%" + txtSearch + "%' or lateGuaranteeDay like N'%" + txtSearch
					+ "%' or routeID like N'%" + txtSearch + "%'");
			while (rs.next()) {
				BusDetails chuyen = new BusDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("routeID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("SERIAL"));
////				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("NAMEBUSSTOP"));
				chuyen.setBusID(rs.getNString("BusID"));
				chuyen.setLicensePlate(rs.getNString("licensePlate"));
				chuyen.setKind(rs.getNString("kind"));
				chuyen.setManufactureDay(rs.getDate("ManufactureDay"));
				chuyen.setLateGuaranteeDay(rs.getDate("LateGuaranteeDay"));
				chuyen.setRouteID(rs.getInt("RouteID"));
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

	public List<BusUnitManagerDetails> getSearchUnit(String txtSearch) {
		List<BusUnitManagerDetails> result = new ArrayList<BusUnitManagerDetails>();
		List<BusUnitManagerDetails> chuyens = new ArrayList<BusUnitManagerDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusUnitManager where unitID like N'%" + txtSearch
					+ "%' or unitName like N'%" + txtSearch + "%' or phoneNumber like N'%" + txtSearch
					+ "%' or email like N'%" + txtSearch + "%'");
			while (rs.next()) {
				BusUnitManagerDetails chuyen = new BusUnitManagerDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("routeID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("SERIAL"));
////				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("NAMEBUSSTOP"));
				chuyen.setUnitID(rs.getNString("unitID"));
				chuyen.setUnitName(rs.getNString("unitName"));
				chuyen.setPhoneNumber(rs.getNString("phoneNumber"));
				chuyen.setEmail(rs.getNString("email"));
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

	public int getCount() {
		int result = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(id) as number from Chuyen");
			while (rs.next()) {
				result = rs.getInt("number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return result;

	}

	public static void main(String[] args) {
//		System.out.println(new SearchDAO().getSearch("Sài"));
//		System.out.println(new SearchDAO().getSearchBus("2020"));
		System.out.println(new SearchDAO().getSearchUnit("liên"));

//		System.out.println(new SearchDAO().getCount());
	}
}
