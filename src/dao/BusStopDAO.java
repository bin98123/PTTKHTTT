package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import model.BusDetails;
import model.BusRouteDetails;
import model.BusStopDetails;
import model.BusUnitManagerDetails;
import model.ChuyenXe;
import model.DriverDetails;
import model.Path;

public class BusStopDAO implements POI_API_DAO {
	private List<Integer> list = new ArrayList<>();
	private ArrayList<String> tramqua;
	private ArrayList<ChuyenXe> chuyenxe = new ArrayList<>();
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_BusStopTemp_SQL = "INSERT INTO BusStopTemp0" + "  (routeID , serial , nameBusStop,id) VALUES ";
	String INSERT_BusStop_SQL = "INSERT INTO BusStop" + "  (routeID , serial , nameBusStop)  VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public BusStopDAO() {

	}

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
		System.out.println("dsfsfsfs là: " + result.isEmpty());
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
				System.out.println("Chuyến xe buýt lượt về số " + Math.abs(Integer.parseInt(routeID)) + ":");
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

	public float getMaxID() throws SQLException, ClassNotFoundException {
		float result = 0;
//		select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select max(id) as maxID from BusStopTemp0;");
			if (rs0.next()) {
				result = rs0.getFloat("maxID");
			} else {

				result = System.currentTimeMillis();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public int edit(BusStopDetails BusStop, int routeID, int serial) throws ClassNotFoundException, SQLException {
		int result = 0;
//		Class.forName("org.hsqldb.jdbcDriver");
		Class.forName(driver);
//		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{

			// Step 3: Execute the query or update query
			try {
				Statement statement = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			String uName = user.getUserName();
//			String uIGName = user.getUserNameIG();
//			String uEmail = user.getUserEmail();

//			try (PreparedStatement insert = connection
//					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, " + "(N'Quốc Khánh Trịnh Lê Ka')" + ", ?,?,?);")) {
			try (PreparedStatement insert = connection
					.prepareStatement("UPDATE BusStop SET nameBusStop = ? WHERE routeID = ? and serial =?;")) {
//				System.out.println(driverDetails.getFullName());
//				String driverID = rs0.getNString("driverID");
//				String fullName = rs0.getNString("fullName");
//				Date birthday = rs0.getDate("birthday");
//				boolean male = rs0.getBoolean("male");
//				String address = rs0.getNString("address");
//				String country = rs0.getNString("country");
//				Date dayBegin = rs0.getDate("dayBegin");
//				int salary = rs0.getInt("salary");
//				String driverLicense = rs0.getNString("driverLicense");
//				String BusID = rs0.getNString("BusID");
				insert.setString(1, BusStop.getNameBusStop());
				insert.setInt(2, routeID);
				insert.setInt(3, serial);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public List<BusStopDetails> getChuyens() {
		List<BusStopDetails> result = new ArrayList<BusStopDetails>();
		List<BusStopDetails> chuyens = new ArrayList<BusStopDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusStop ORDER BY routeID DESC,serial ASC");
			while (rs.next()) {
				BusStopDetails chuyen = new BusStopDetails();
//				available++;
//				System.out.println("Khanh");
				chuyen.setRouteID(rs.getInt("routeID"));
//				System.out.println(rs.getFloat("ID"));
				chuyen.setSerial(rs.getInt("serial"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setNameBusStop(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
//				if (!chuyens.contains(chuyen)) {
				chuyens.add(chuyen);
//				}
//				for (BusStopDetails BusStopDetails : chuyens) {
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

	public List<BusStopDetails> getTrams() {
		List<BusStopDetails> result = new ArrayList<BusStopDetails>();
		List<BusStopDetails> chuyens = new ArrayList<BusStopDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct nameBusStop from BusStop");
			while (rs.next()) {
				BusStopDetails chuyen = new BusStopDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setNameBusStop(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (BusStopDetails BusStopDetails : chuyens) {
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
//				BusStopDetails chuyen = new BusStopDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
//				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("TenTram"));
//				System.out.println(rs.getNString("TenTram"));
				result.add(rs.getNString("nameBusStop"));
//				for (BusStopDetails BusStopDetails : chuyens) {
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

	public int checkExist(BusStopDetails busDetails) {
		int count = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			System.out.println(busDetails);
//			ResultSet rs = stmt.executeQuery("select * from BusStop where nameBusStop like '" + busDetails.getNameBusStop()
//				+ "'");
			ResultSet rs = stmt.executeQuery("select * from BusStop where serial =" + busDetails.getSerial()
					+ " and routeID =" + busDetails.getRouteID() + ";");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				count++;
//				System.out.println(name);
//				System.out.println(count);

//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return count;

	}

	public int add(BusStopDetails driverDetails) throws ClassNotFoundException, SQLException {
		int result = 0;
		System.out.println(driverDetails);
//		Class.forName("org.hsqldb.jdbcDriver");
		Class.forName(driver);
//		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		if (checkExist(driverDetails) == 0) {
			try (Connection connection = DriverManager.getConnection(connectionUrl))

			{

				// Step 3: Execute the query or update query
				try {
					Statement statement = connection.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//			String uName = user.getUserName();
//			String uIGName = user.getUserNameIG();
//			String uEmail = user.getUserEmail();

//			try (PreparedStatement insert = connection
//					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, " + "(N'Quốc Khánh Trịnh Lê Ka')" + ", ?,?,?);")) {
				try (PreparedStatement insert = connection
						.prepareStatement(INSERT_BusStop_SQL + " (?,?,(N'" + driverDetails.getNameBusStop() + "'));")) {
					// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setInt(1, driverDetails.getRouteID());
					insert.setInt(2, driverDetails.getSerial());
//				insert.executeUpdate();
					result = insert.executeUpdate();

				}

			}
		}
		return result;

	}

	public boolean delete(int id, int serialIn) throws ClassNotFoundException, SQLException {
		boolean result = false;

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt
					.executeQuery("select * from BusStop WHERE routeID=" + id + " and serial=" + serialIn + ";");
			while (rs0.next()) {
				int routeID = rs0.getInt("routeID");
				int serial = rs0.getInt("serial");
				String nameBusStop = rs0.getNString("nameBusStop");

				try (PreparedStatement insert = con.prepareStatement(INSERT_BusStopTemp_SQL + " (?, ?, ?,?);")) {
					// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setInt(1, routeID);
					insert.setInt(2, serial);
					insert.setNString(3, nameBusStop);
					insert.setFloat(4, System.currentTimeMillis() + getMaxID());
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
//					insert.close();
				}
				Statement stmt1 = con.createStatement();
				int rs2 = stmt1
						.executeUpdate("delete from BusStop where routeID=" + id + " and serial=" + serialIn + ";");
				if (rs2 > 0) {
					result = true;
				}
				con.commit();
//				stmt1.close();
			}
//		rs.close();
//		con.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				if (con != null)
					con.rollback();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // Ket thuc khoi try

		} catch (Exception e) {
			// Xu ly cac loi cho Class.forName
			e.printStackTrace();

		}
		return result;
	}

	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		boolean result = false;

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
//			ResultSet rs0 = stmt
//					.executeQuery("select * from BusStop WHERE routeID=" + id + " and serial=" + serialIn + ";");
//			while (rs0.next()) {
//				int routeID = rs0.getInt("routeID");
//				int serial = rs0.getInt("serial");
//				String nameBusStop = rs0.getNString("nameBusStop");
			float currentTime = System.currentTimeMillis() + getMaxID();
			String INSERT_BusStopTemp = "INSERT INTO BusStopTemp0" + "  (routeID , serial , nameBusStop)";
			try (PreparedStatement insert = con
					.prepareStatement(INSERT_BusStopTemp + " SELECT routeID , serial , nameBusStop from BusStop;")) {
				// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
//					insert.setInt(1, routeID);
//					insert.setInt(2, serial);
//					insert.setNString(3, nameBusStop);
//				insert.setFloat(1, System.currentTimeMillis() + getMaxID());
//				int rs1 = insert.executeUpdate();

				insert.executeUpdate();

//					insert.close();
			}
//			Statement stmt2 = con.createStatement();
			PreparedStatement insert1 = con
					.prepareStatement("UPDATE BusStopTemp0 " + "SET id = " + currentTime + "where id is null;");
			insert1.executeUpdate();
			con.commit();
			if (con != null)
				con.rollback();

			////
			Statement stmt1 = con.createStatement();
			int rs2 = stmt1.executeUpdate("delete from BusStop;");
			if (rs2 > 0) {
				result = true;
			}
			con.commit();
//				stmt1.close();
//			}
//		rs.close();
//		con.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				if (con != null)
					con.rollback();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // Ket thuc khoi try

		} catch (Exception e) {
			// Xu ly cac loi cho Class.forName
			e.printStackTrace();

		}
		return result;
	}

	public void rollback() throws SQLException {
//	select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);

			ResultSet rs0 = stmt
					.executeQuery("select * from BusStopTemp0 where id=(select max(id) from BusStopTemp0);");
			while (rs0.next()) {
				int routeID = rs0.getInt("routeID");
				int serial = rs0.getInt("serial");
				String nameBusStop = rs0.getNString("nameBusStop");

				try (PreparedStatement insert = con.prepareStatement(INSERT_BusStop_SQL + " (?, ?, ?);")) {
					// 1private String accountID;
//		2private String accountName;
//		3private String password;
//		4private String fullName;
//		5private Date birthday;
//		6private String email;
//		7private String phoneNumber;
//		insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setInt(1, routeID);
					insert.setInt(2, serial);
					insert.setNString(3, nameBusStop);
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
					insert.close();
				}
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate("delete from BusStopTemp0 where id=(select max(id) from BusStopTemp0);");
				con.commit();
				stmt1.close();
			}
//	rs.close();
//	con.close();
//	} catch (Exception e) {
//		// TODO: handle exception
//	}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				if (con != null)
					con.rollback();
			} catch (SQLException se2) {
				se2.printStackTrace();
			} // Ket thuc khoi try

		} catch (Exception e) {
			// Xu ly cac loi cho Class.forName
			e.printStackTrace();

		}
	}

	// export excel file
	@Override
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
			ResultSet rs = stmt.executeQuery("select * from BusStop;");
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(new DriverDAO().deleteDriver("d01"));
//		new DriverDAO().rollback();
//		DriverDetails driverDetails = new DriverDetails(null, "Lê Thành Nam", new Date(1970, 8, 30), true, "Huế",
//				"Việt Nam", new Date(2017, 1, 28), 11000000, "843877483", "bus003");
//		System.out.println(new DriverDAO().edit(driverDetails, "d01"));
//		BusStopDetails busStopDetails = new BusStopDetails(0, 0, "Bến xe buýt Sài Gòn");
//		System.out.println(new BusStopDAO().edit(busStopDetails, 19, 1));
//		System.out.println(new BusStopDAO().checkExist(new BusStopDetails(88, 0, "Cát Lái")));
		System.out.println(new BusStopDAO().deleteAll());
	}

	/////////////////////////////////////////////////
	// Import From file Excel
	@Override
	public void selectFile() throws IOException, ClassNotFoundException, SQLException {
		JFrame parentFrame = new JFrame();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			@Override
			public boolean accept(java.io.File file) {
				return (file.getName().toLowerCase().endsWith(".xls"));
			}

			@Override
			public String getDescription() {
				return "Microsoft Excel 97-2003 Worksheet";
			}
		});

		fileChooser.setDialogTitle("Specify a file to save");

//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Open Resource File");

		int userSelection = fileChooser.showSaveDialog(parentFrame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
//			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());

//		String fileName = "C:\\Users\\quockhanh156\\Downloads\\Accounts.xls";
			String fileName = fileToSave.getAbsolutePath();
			// Read an Excel File from C:\\test.xls and Store in a Vector
			Vector dataHolder = readExcelFile(fileName);
			// Print the data read
//			printCellDataToConsole(dataHolder);
			for (int j = 0; j < printCellDataToConsole(dataHolder, fileName).size(); j++) {
				if (!printCellDataToConsole(dataHolder, fileName).get(j).toString().equals("")) {
					BusStopDAO dao = new BusStopDAO();
					dao.add(printCellDataToConsole(dataHolder, fileName).get(j));
//					System.out.println(printCellDataToConsole(dataHolder, fileName).get(j));
				}
			}

//			System.exit(0);
		}
	}

	@Override
	public Vector readExcelFile(String fileName) {
		/**
		 * --Define a Vector --Holds Vectors Of Cells
		 */
		Vector cellVectorHolder = new Vector();
		try {
			/** Creating Input Stream **/
			// InputStream myInput= ReadExcelFile.class.getResourceAsStream( fileName );
			FileInputStream myInput = new FileInputStream(fileName);
			/** Create a POIFSFileSystem object **/
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
			/** Create a workbook using the File System **/
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
			/** Get the first sheet from workbook **/
			HSSFSheet mySheet = myWorkBook.getSheetAt(0);
			int rowTotal = mySheet.getLastRowNum();

			if ((rowTotal > 0) || (mySheet.getPhysicalNumberOfRows() > 0)) {
				rowTotal++;
			}
			int row = rowTotal - 1;
			/** We now need something to iterate through the cells. **/
			Iterator rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	private List<BusStopDetails> printCellDataToConsole(Vector dataHolder, String fileName) throws IOException {
		FileInputStream myInput = new FileInputStream(fileName);
		/** Create a POIFSFileSystem object **/
		POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
		/** Create a workbook using the File System **/
		HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
		/** Get the first sheet from workbook **/
		HSSFSheet mySheet = myWorkBook.getSheetAt(0);
		int rowTotal = mySheet.getLastRowNum();

		if ((rowTotal > 0) || (mySheet.getPhysicalNumberOfRows() > 0)) {
			rowTotal++;
		}
		List<BusStopDetails> ListBusDetails = new ArrayList<BusStopDetails>();
		BusStopDetails busDetails = new BusStopDetails();
		List<String> containListBus = new ArrayList<String>();
		try {

			for (int i = 1; i < rowTotal; i++) {
				Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
				for (int j = 0; j < cellStoreVector.size(); j++) {
					HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
					String stringCellValue = myCell.toString();
//					System.out.print(stringCellValue + "\t");
//					if (!containListBus.contains(stringCellValue)) {
					containListBus.add(j, stringCellValue);
//					}
					// Print Each cell here

				}
				busDetails = new BusStopDetails(Integer.parseInt(containListBus.get(0)),
						Integer.parseInt(containListBus.get(1)), containListBus.get(2));
				ListBusDetails.add(i - 1, busDetails);
				busDetails = new BusStopDetails();
//				System.out.println(containListBus);
//				System.out.println(containListBus.get(3));
//				System.out.println(containListBus.get(5));
//				System.out.println(busDetails);
//				System.out.println();
				if (ListBusDetails.get(i - 1).toString().equals("")) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListBusDetails;
	}

	/////////////////////////////////////////////////
}