package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.BusUnitManagerDetails;

public class UnitDAO {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_BusUnitManagerTemp_SQL = "INSERT INTO BusUnitManagerTemp"
			+ "  (unitID,unitName,phoneNumber , Email,id) VALUES ";
	String INSERT_BusUnitManager_SQL = "INSERT INTO BusUnitManager" + "  (unitID,unitName,phoneNumber , Email) VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public UnitDAO() {

	}

	public int edit(BusUnitManagerDetails unit, String unitID) throws ClassNotFoundException, SQLException {
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
			try (PreparedStatement insert = connection.prepareStatement(
					"UPDATE BusUnitManager SET unitName = ?, phoneNumber= ?, Email= ? WHERE unitID = ?;")) {
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
				insert.setString(1, unit.getUnitName());
				insert.setString(2, unit.getPhoneNumber());
				insert.setString(3, unit.getEmail());
				insert.setString(4, unitID);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public int add(BusUnitManagerDetails unitDetails) throws ClassNotFoundException, SQLException {
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
			try (PreparedStatement insert = connection.prepareStatement(
					INSERT_BusUnitManager_SQL + " ((N'" + unitDetails.getUnitID() + "'),(N'" + unitDetails.getUnitName()
							+ "'),(N'" + unitDetails.getPhoneNumber() + "'),(N'" + unitDetails.getEmail() + "'));")) {
				// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public boolean deleteUnit(String id) throws ClassNotFoundException, SQLException {
		boolean result = false;

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select * from BusUnitManager WHERE unitID='" + id + "';");
			while (rs0.next()) {
				String unitID = rs0.getNString("unitID");
				String unitName = rs0.getNString("unitName");
				String phoneNumber = rs0.getNString("phoneNumber");
				String email = rs0.getNString("Email");

				try (PreparedStatement insert = con
						.prepareStatement(INSERT_BusUnitManagerTemp_SQL + " (?, ?, ?,?,?);")) {
					// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setString(1, unitID);
					insert.setString(2, unitName);
					insert.setString(3, phoneNumber);
					insert.setString(4, email);
					insert.setFloat(5, System.currentTimeMillis() + getMaxID());
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
//					insert.close();
				}
				Statement stmt1 = con.createStatement();
				int rs2 = stmt1.executeUpdate("delete from BusUnitManager where unitID='" + id + "';");
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

	public float getMaxID() throws SQLException, ClassNotFoundException {
		float result = 0;
//		select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select max(id) as maxID from BusUnitManagerTemp;");
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

	public void rollback() throws SQLException {
//	select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery(
					"select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);");
			while (rs0.next()) {
				String unitID = rs0.getNString("unitID");
				String unitName = rs0.getNString("unitName");
				String phoneNumber = rs0.getNString("phoneNumber");
				String email = rs0.getNString("Email");

				try (PreparedStatement insert = con.prepareStatement(INSERT_BusUnitManager_SQL + " (?, ?, ?,?);")) {
					// 1private String accountID;
//		2private String accountName;
//		3private String password;
//		4private String fullName;
//		5private Date birthday;
//		6private String email;
//		7private String phoneNumber;
//		insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setString(1, unitID);
					insert.setString(2, unitName);
					insert.setString(3, phoneNumber);
					insert.setString(4, email);
//			int rs1 = insert.executeUpdate();

					insert.executeUpdate();
					insert.close();
				}
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(
						"delete from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);");
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
//		System.out.println(new BusDAO().deleteUnit("u18"));
//		new BusDAO().rollback();
//		BusUnitManagerDetails unitDetails = new BusUnitManagerDetails("u19", "Khanh", "878787", "khanh@gmail.com");
//		System.out.println(new BusDAO().add(unitDetails));
		System.out.println(new UnitDAO().getMaxID());

	}
}