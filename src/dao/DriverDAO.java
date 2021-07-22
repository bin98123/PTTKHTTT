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
import model.DriverDetails;

public class DriverDAO {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_DriverTemp_SQL = "INSERT INTO DriverTemp"
			+ "  (driverID , fullName , birthday , male , address , country, dayBegin, salary, driverLicense, BusID,id) VALUES ";
	String INSERT_Driver_SQL = "INSERT INTO Driver"
			+ "  (driverID , fullName , birthday , male , address , country, dayBegin, salary, driverLicense, BusID)  VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public DriverDAO() {

	}

	public int edit(DriverDetails driverDetails, String driverID) throws ClassNotFoundException, SQLException {
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
					"UPDATE Driver SET fullName = ?, birthday= ?, male= ?, address= ?, country= ?, dayBegin= ?, salary= ?, driverLicense= ?, BusID= ? WHERE driverID = ?;")) {
				System.out.println(driverDetails.getFullName());
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
				insert.setString(1, driverDetails.getFullName());
				insert.setDate(2,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getBirthday())));
				insert.setBoolean(3, driverDetails.getMale());
				insert.setNString(4, driverDetails.getAddress());
				insert.setNString(5, driverDetails.getCountry());
				insert.setDate(6,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getDayBegin())));
				insert.setInt(7, driverDetails.getSalary());
				insert.setNString(8, driverDetails.getDriverLicense());
				insert.setNString(9, driverDetails.getBusID());
				insert.setNString(10, driverID);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public int add(DriverDetails driverDetails) throws ClassNotFoundException, SQLException {
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
			try (PreparedStatement insert = connection.prepareStatement(INSERT_Driver_SQL + " ((N'"
					+ driverDetails.getDriverID() + "'),(N'" + driverDetails.getFullName() + "'), ?,?,(N'"
					+ driverDetails.getAddress() + "'),(N'" + driverDetails.getCountry() + "'),?,?,(N'"
					+ driverDetails.getDriverLicense() + "'),(N'" + driverDetails.getBusID() + "'));")) {
				System.out.println(driverDetails.getFullName());
				// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
				insert.setDate(1,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getBirthday())));
				insert.setBoolean(2, driverDetails.getMale());
//				insert.setNString(4, "N'" + account.getFullName() + "'");
				insert.setDate(3,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getDayBegin())));
				insert.setInt(4, driverDetails.getSalary());
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public boolean deleteDriver(String id) throws ClassNotFoundException, SQLException {
		boolean result = false;

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select * from Driver WHERE driverID='" + id + "';");
			while (rs0.next()) {
				String driverID = rs0.getNString("driverID");
				String fullName = rs0.getNString("fullName");
				Date birthday = rs0.getDate("birthday");
				boolean male = rs0.getBoolean("male");
				String address = rs0.getNString("address");
				String country = rs0.getNString("country");
				Date dayBegin = rs0.getDate("dayBegin");
				int salary = rs0.getInt("salary");
				String driverLicense = rs0.getNString("driverLicense");
				String BusID = rs0.getNString("BusID");

				try (PreparedStatement insert = con
						.prepareStatement(INSERT_DriverTemp_SQL + " (?, ?, ?,?,?,?, ?, ?,?,?,?);")) {
					// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setNString(1, driverID);
					insert.setNString(2, fullName);
					insert.setDate(3, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(birthday)));
					insert.setBoolean(4, male);
					insert.setNString(5, address);
					insert.setNString(6, country);
					insert.setDate(7, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dayBegin)));
					insert.setInt(8, salary);
					insert.setNString(9, driverLicense);
					insert.setNString(10, BusID);
					insert.setFloat(11, System.currentTimeMillis());
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
//					insert.close();
				}
				Statement stmt1 = con.createStatement();
				int rs2 = stmt1.executeUpdate("delete from Driver where driverID='" + id + "';");
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
			ResultSet rs0 = stmt.executeQuery("select * from DriverTemp where id=(select max(id) from DriverTemp);");
			while (rs0.next()) {
				String driverID = rs0.getNString("driverID");
				String fullName = rs0.getNString("fullName");
				Date birthday = rs0.getDate("birthday");
				boolean male = rs0.getBoolean("male");
				String address = rs0.getNString("address");
				String country = rs0.getNString("country");
				Date dayBegin = rs0.getDate("dayBegin");
				int salary = rs0.getInt("salary");
				String driverLicense = rs0.getNString("driverLicense");
				String BusID = rs0.getNString("BusID");

				try (PreparedStatement insert = con
						.prepareStatement(INSERT_Driver_SQL + " (?,?, ?, ?,?,?, ?, ?,?,?);")) {
					// 1private String accountID;
//		2private String accountName;
//		3private String password;
//		4private String fullName;
//		5private Date birthday;
//		6private String email;
//		7private String phoneNumber;
//		insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setNString(1, driverID);
					insert.setNString(2, fullName);
					insert.setDate(3, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(birthday)));
					insert.setBoolean(4, male);
					insert.setNString(5, address);
					insert.setNString(6, country);
					insert.setDate(7, java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dayBegin)));
					insert.setInt(8, salary);
					insert.setNString(9, driverLicense);
					insert.setNString(10, BusID);
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
					insert.close();
				}
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate("delete from DriverTemp where id=(select max(id) from DriverTemp);");
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