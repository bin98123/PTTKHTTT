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
							+ "' and routeID = " + getBus().get(i) + ")" + "order by routeID, serial asc");
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

	public List<String> search0(String diemDi, String diemDen) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		List<String> result = new ArrayList<String>();
		ResultSet re;

		tramqua = new ArrayList<>();

		re = sta.executeQuery("select distinct routeID from BusStop ");
		while (re.next()) {
//			System.out.println(re.getString("routeID"));
			result.add(re.getString("routeID"));

		}
		return result;
	}

	public List<String> getAllRouteID() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		List<String> result = new ArrayList<String>();
		ResultSet re;

		tramqua = new ArrayList<>();

		re = sta.executeQuery("select distinct routeID from BusStop");
		while (re.next()) {
//			System.out.println(re.getString("routeID"));
			result.add(re.getString("routeID"));

		}
		return result;
	}

	public int countNameBusStop(String routeID) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		int result = 0;
		ResultSet re;

		tramqua = new ArrayList<>();

		re = sta.executeQuery("select count(nameBusStop) as countResult from BusStop where routeID =" + routeID);
		while (re.next()) {
//			System.out.println(re.getInt("countResult"));
			result = re.getInt("countResult");

		}
		return result;
	}

	public List<String> getPathOfRoute(String routeID) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Statement sta = getConnect().createStatement();
		List<String> result = new ArrayList<String>();
		ResultSet re;

		tramqua = new ArrayList<>();

		re = sta.executeQuery(
				"select nameBusStop from BusStop where routeID=" + Integer.parseInt(routeID) + "ORDER BY serial ASC");
//		for (int i = 0; i < countNameBusStop(routeID); i++) {

		while (re.next()) {
//			System.out.println(re.getString("nameBusStop"));
			result.add(re.getString("nameBusStop"));

		}
//		}
		return result;
	}

	public Path checkHasPath(String diemDi, String diemDen, String routeID)
			throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Path result = null;
		List<String> list = getPathOfRoute(routeID);

		if (list.contains(diemDen) && list.contains(diemDi)) {
			result = new Path(list.indexOf(diemDi), (list.indexOf(diemDen)));
			if ((list.indexOf(diemDi)) == (list.indexOf(diemDen))) {
				return null;
			}
//			System.out.println(list.indexOf(diemDi));
//			System.out.println(list.indexOf(diemDen));
		}
		return result;
	}

	public void printPath(String diemDi, String diemDen, String routeID) throws ClassNotFoundException, SQLException {
		Path path = checkHasPath(diemDi, diemDen, routeID);
		List<String> list = getPathOfRoute(routeID);
		if (path != null) {
			if (Integer.parseInt(routeID) > 0) {
				System.out.println("Chuyến xe buýt lượt đi số " + routeID + ":");
				if (path.getDes() > path.getStart()) {
					for (int i = path.getStart(); i <= path.getDes(); i++) {
						System.out.println(list.get(i));
					}
				} else {
					for (int i = path.getDes(); i <= path.getStart(); i++) {
						System.out.println(list.get(i));

					}
				}
			} else {
				System.out.println("Chuyến xe buýt lượt về số " + Math.abs(Integer.parseInt(routeID))  + ":");
				if (path.getDes() > path.getStart()) {
					for (int i = path.getStart(); i <= path.getDes(); i++) {
						System.out.println(list.get(i));
					}
				} else {
					for (int i = path.getDes(); i <= path.getStart(); i++) {
						System.out.println(list.get(i));

					}
				}
			}
		}
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
//		System.out.println(c.search("Hồ Bơi", "Bến xe Lam Hồng"));
		System.out.println(c.search("Bến xe Lam Hồng", "Hồ Bơi"));
		List<String> list = new ChuyenXeDB().getAllRouteID();
		for (int i = 0; i < list.size(); i++) {

//			System.out.println("---Đường đi tìm được");
//			c.printPath("Hồ Bơi", "Nhà văn hoá sinh viên", list.get(i));
			c.printPath("Suối Tiên", "Đại học Nông Lâm", list.get(i));
		}
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
