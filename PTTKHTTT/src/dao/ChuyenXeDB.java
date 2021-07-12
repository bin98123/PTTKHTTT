package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ChuyenXe;

public class ChuyenXeDB {
	private List<Integer> list = new ArrayList<>();
	private ArrayList<String> tramqua;
	private ArrayList<ChuyenXe> chuyenxe = new ArrayList<>();
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
	String INSERT_ACCOUNT_SQL = "INSERT INTO Account"
			+ "  (accountID,accountName,password , fullName, birthday, email, phoneNumber) VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public Connection getConnect() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
//		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyXeBus;user=sa;password=root";
		Connection con = DriverManager.getConnection(connectionUrl);
		return con;
	}

//ds cac chuyen bus trong csdl
	public List<Integer> getBus() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		ResultSet re = sta.executeQuery("select distinct routeID from BusStop");
		int id;

		while (re.next()) {
			id = re.getInt(1);
			list.add(id);
		}
		return list;
	}

//	public ArrayList<ChuyenXe> search(String diemDi, String diemDen) throws SQLException {
//		Statement sta = getConnect().createStatement();
//		ResultSet re;
//		int j = getBus().size();
//
//		for (int i = 0; i < j; i++) {
//
//			tramqua = new ArrayList<>();
//
//			re = sta.executeQuery(
//					"select TenTram from Chuyen where  STT >= (select top(1) STT from Chuyen where TenTram = N'"
//							+ diemDi + "' and ID =" + getBus().get(i) + ") and ID = " + getBus().get(i)
//							+ " and STT < =(select top(1) STT from Chuyen where TenTram = N'" + diemDen + "' and ID = "
//							+ getBus().get(i) + ")");
//			while (re.next()) {
//				tramqua.add(re.getString(1));
//			}
//			if (tramqua.size() > 0) {
//				chuyenxe.add(new ChuyenXe(getBus().get(i), tramqua));
//			}
//
//		}
//
//		return chuyenxe;
//	}
//	
	public List<String> search(String diemDi, String diemDen) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		List<String> result = new ArrayList<String>();
		ResultSet re;
		int j = getBus().size();

		for (int i = 0; i < j; i++) {

			tramqua = new ArrayList<>();

			re = sta.executeQuery(
					"select nameBusStop from BusStop where  serial >= (select top(1) serial from BusStop where nameBusStop = N'"
							+ diemDi + "' and routeID =" + getBus().get(i) + ") and routeID = " + getBus().get(i)
							+ " and serial < =(select top(1) serial from BusStop where nameBusStop = N'" + diemDen
							+ "' and routeID = " + getBus().get(i) + ")");
			while (re.next()) {
				tramqua.add(re.getNString(1));
			}
//			if (!re.next()) {
//				result = null;
//			}
			if (tramqua.size() > 0) {
				chuyenxe.add(new ChuyenXe(getBus().get(i), tramqua));
			}
		}
//		String s = "";
		for (ChuyenXe c : chuyenxe) {
//			s = s + c.toString() + "\n" + "\n";
			result.add(c.toString());
		}
		if (chuyenxe == null) {
			result.add(0, "");
		}
		return result;
	}

//	public String prinChuyenXe() {
//		// TODO Auto-generated method stub
//		String s = "";
//		for (ChuyenXe c : chuyenxe) {
//			s = s + c.toString() + "\n" + "\n";
//		}
//		return s;
//	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ChuyenXeDB c = new ChuyenXeDB();
//		List<String> c1 = null;
//		System.out.println(c.search("Suối Tiên", "Đại học Nông Lâm"));
		System.out.println(c.search("Hồ Bơi", "Bến xe Lam Hồng"));
//		System.out.println(c.search("Hồ Bơi", "Bến xe Lamxs Hồng").size() == 0);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng").toString());
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") == null);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") != null);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") == null);
//		c.search();
//		System.out.println(c.prinChuyenXe());
	}
}
