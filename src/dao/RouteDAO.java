package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.AccountDetails;
import model.BusRouteDetails;
import model.DriverDetails;

public class RouteDAO {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_RouteTemp_SQL = "INSERT INTO BusRouteTemp"
			+ "  (routeID , unitID , routeName , timeStart , timeEnd , timeBreak, startLocation, endLocation, kindRoute,id) VALUES ";
	String INSERT_Route_SQL = "INSERT INTO BusRoute"
			+ "  (routeID , unitID , routeName , timeStart , timeEnd , timeBreak, startLocation, endLocation, kindRoute)  VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public RouteDAO() {

	}

	public float getMaxID() throws SQLException, ClassNotFoundException {
		float result = 0;
//		select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select max(id) as maxID from BusRouteTemp;");
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

	public int edit(BusRouteDetails driverDetails, String routeID) throws ClassNotFoundException, SQLException {
		int result = 0;
		System.out.println(driverDetails);
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
			try (PreparedStatement insert = connection.prepareStatement(
					"UPDATE BusRoute SET unitID = ?, routeName= ?, timeStart= ?, timeEnd= ?, timeBreak= ?, startLocation= ?, endLocation= ?, kindRoute= ? WHERE routeID = ?;")) {
				System.out.println(driverDetails.getUnitID());
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
				insert.setNString(1, driverDetails.getUnitID());
				insert.setNString(2, driverDetails.getRouteName());
				insert.setNString(3, driverDetails.getTimeStart());
				insert.setNString(4, driverDetails.getTimeEnd());
				insert.setDouble(5, driverDetails.getTimeBreak());
				insert.setNString(6, driverDetails.getStartLocation());
				insert.setNString(7, driverDetails.getEndLocation());
				insert.setNString(8, driverDetails.getKindRoute());
				insert.setNString(9, routeID);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public int add(BusRouteDetails route) throws ClassNotFoundException, SQLException {
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
					.prepareStatement(INSERT_Route_SQL + " (?,?,?,?,?,?,(N'" + route.getStartLocation() + "'),(N'"
							+ route.getEndLocation() + "'),(N'" + route.getKindRoute() + "'));")) {
				// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
				insert.setInt(1, route.getRouteID());
				insert.setString(2, route.getUnitID());
				insert.setNString(3, route.getRouteName());
				insert.setString(4, route.getTimeStart());
				insert.setString(5, route.getTimeEnd());
				insert.setDouble(6, route.getTimeBreak());
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		boolean result = false;

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select * from BusRoute WHERE routeID=" + id + ";");
			while (rs0.next()) {
				int routeID = rs0.getInt("routeID");
				String unitID = rs0.getNString("unitID");
				String routeName = rs0.getNString("routeName");
				String timeStart = rs0.getNString("timeStart");
				String timeEnd = rs0.getNString("timeEnd");
				Double timeBreak = rs0.getDouble("timeBreak");
				String startLocation = rs0.getNString("startLocation");
				String endLocation = rs0.getNString("endLocation");
				String kindRoute = rs0.getNString("kindRoute");

				try (PreparedStatement insert = con
						.prepareStatement(INSERT_RouteTemp_SQL + " (?, ?, ?,?,?,?, ?, ?,?,?);")) {
					// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setInt(1, routeID);
					insert.setNString(2, unitID);
					insert.setNString(3, routeName);
					insert.setNString(4, timeStart);
					insert.setNString(5, timeEnd);
					insert.setDouble(6, timeBreak);
					insert.setNString(7, startLocation);
					insert.setNString(8, endLocation);
					insert.setNString(9, kindRoute);
					insert.setFloat(10, System.currentTimeMillis() + getMaxID());
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
//					insert.close();
				}
				Statement stmt1 = con.createStatement();
				int rs2 = stmt1.executeUpdate("delete from BusRoute where routeID=" + id + ";");
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

	public void rollback() throws SQLException {
//	select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt
					.executeQuery("select * from BusRouteTemp where id=(select max(id) from BusRouteTemp);");
			while (rs0.next()) {
				int routeID = rs0.getInt("routeID");
				String unitID = rs0.getNString("unitID");
				String routeName = rs0.getNString("routeName");
				String timeStart = rs0.getNString("timeStart");
				String timeEnd = rs0.getNString("timeEnd");
				Double timeBreak = rs0.getDouble("timeBreak");
				String startLocation = rs0.getNString("startLocation");
				String endLocation = rs0.getNString("endLocation");
				String kindRoute = rs0.getNString("kindRoute");

				try (PreparedStatement insert = con.prepareStatement(INSERT_Route_SQL + " (?,?, ?, ?,?,?, ?, ?,?);")) {
					// 1private String accountID;
//		2private String accountName;
//		3private String password;
//		4private String fullName;
//		5private Date birthday;
//		6private String email;
//		7private String phoneNumber;
//		insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setInt(1, routeID);
					insert.setNString(2, unitID);
					insert.setNString(3, routeName);
					insert.setNString(4, timeStart);
					insert.setNString(5, timeEnd);
					insert.setDouble(6, timeBreak);
					insert.setNString(7, startLocation);
					insert.setNString(8, endLocation);
					insert.setNString(9, kindRoute);
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
					insert.close();
				}
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate("delete from BusRouteTemp where id=(select max(id) from BusRouteTemp);");
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(new DriverDAO().deleteDriver("d01"));
//		new DriverDAO().rollback();
//		DriverDetails driverDetails = new DriverDetails(null, "Lê Thành Nam", new Date(1970, 8, 30), true, "Huế",
//				"Việt Nam", new Date(2017, 1, 28), 11000000, "843877483", "bus003");
//		System.out.println(new DriverDAO().edit(driverDetails, "d01"));

	}
}