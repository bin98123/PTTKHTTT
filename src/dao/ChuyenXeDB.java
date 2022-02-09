package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import model.ChuyenXe;
import model.Path;

public class ChuyenXeDB {
	private List<Integer> list = new ArrayList<>();
	private ArrayList<String> tramqua;
	private ArrayList<ChuyenXe> chuyenxe = new ArrayList<>();
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
//	String INSERT_ACCOUNT_SQL = "INSERT INTO Account"
//			+ "  (accountID,accountName,password , fullName, birthday, email, phoneNumber) VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ChuyenXeDB c = new ChuyenXeDB();
//		List<String> c1 = null;
//		System.out.println(c.search("Suối Tiên", "Đại học Nông Lâm"));
//		System.out.println(c.search("Hồ Bơi", "Bến xe Lam Hồng"));
//		System.out.println(c.search("Bến xe Lam Hồng", "Hồ Bơi"));
//		List<String> list = new ChuyenXeDB().getAllRouteID();
//		for (int i = 0; i < list.size(); i++) {
//
////			System.out.println("---Đường đi tìm được");
////			c.printPath("Hồ Bơi", "Nhà văn hoá sinh viên", list.get(i));
//			c.printPath("Suối Tiên", "Đại học Nông Lâm", list.get(i));
//		}
//		c.printPath("Hồ Bơi", "Nhà văn hoá sinh viên", "88");
//		System.out.println("Chuyến xe bus tìm được là:" + c.getAllRouteID());
//		System.out.println("Chuyến xe bus tìm được là:" + c.getBusIDHasPath("Hồ Bơi", "Bến xe Lam Hồng"));
//		System.out.println("Chuyến xe bus tìm được là:" + c.getBusIDHasPath("Đường số 6", "Bến xe Lam Hồng"));

//		System.out.println("Chuyến xe bus tìm được là:" + c.getPathOfRoute("88").get(54));
//		System.out.println("Chuyến xe bus tìm được là:" + c.checkHasPath("Ngã ba Long Thuận", "Trại nhím", "88"));
//		System.out.println("Chuyến xe bus tìm được là:" + c.checkHasPath("Ngã ba Long Thuận", "Cầu Đen", "88"));
//		System.out.println("Chuyến xe bus tìm được là:" + c.checkHasPath("Đại học Quốc gia", "Nhà văn hoá sinh viên", "19"));
//		System.out.println("Chuyến xe bus tìm được là:" + c.countNameBusStop("88"));
//		System.out.println(c.search("Hồ Bơi", "Bến xe Lam Hồng").size() == 0);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng").toString());
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") == null);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") != null);
//		System.out.println(c.search("Hồ dsdsBơi", "Bến xe Ldsdsam Hồng") == null);
//		c.search();
//		System.out.println(c.prinChuyenXe());
	}
}
