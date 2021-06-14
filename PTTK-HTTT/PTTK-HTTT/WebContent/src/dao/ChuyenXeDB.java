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

	public Connection getConnect() throws SQLException {

		String dbURL = "jdbc:sqlserver://localhost;databaseName=QuanLyXeBus;user=sa;password=root";
		Connection con = DriverManager.getConnection(dbURL);
		return con;
	}

//ds cac chuyen bus trong csdl
	public List<Integer> getBus() throws SQLException {
		Statement sta = getConnect().createStatement();
		ResultSet re = sta.executeQuery("select distinct ID from Chuyen");
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
	public String search(String diemDi, String diemDen) throws SQLException {
		Statement sta = getConnect().createStatement();
		ResultSet re;
		int j = getBus().size();

		for (int i = 0; i < j; i++) {

			tramqua = new ArrayList<>();

			re = sta.executeQuery(
					"select TenTram from Chuyen where  STT >= (select top(1) STT from Chuyen where TenTram = N'"
							+ diemDi + "' and ID =" + getBus().get(i) + ") and ID = " + getBus().get(i)
							+ " and STT < =(select top(1) STT from Chuyen where TenTram = N'" + diemDen + "' and ID = "
							+ getBus().get(i) + ")");
			while (re.next()) {
				tramqua.add(re.getString(1));
			}
			if (tramqua.size() > 0) {
				chuyenxe.add(new ChuyenXe(getBus().get(i), tramqua));
			}

		}
		String s = "";
		for (ChuyenXe c : chuyenxe) {
			s = s + c.toString() + "\n" + "\n";
		}
		return s;
	}

//	public String prinChuyenXe() {
//		// TODO Auto-generated method stub
//		String s = "";
//		for (ChuyenXe c : chuyenxe) {
//			s = s + c.toString() + "\n" + "\n";
//		}
//		return s;
//	}

	public static void main(String[] args) throws SQLException {
		ChuyenXeDB c = new ChuyenXeDB();
//		System.out.println(c.search("Suối Tiên", "Đại học Nông Lâm"));
		System.out.println(c.search("Hồ Bơi", "Bến xe Lam Hồng"));
//		c.search();
//		System.out.println(c.prinChuyenXe());
	}
}
