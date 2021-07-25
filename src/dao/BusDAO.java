package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.BusDetails;

public class BusDAO {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_BusTemp_SQL = "INSERT INTO BusTemp"
			+ "  (busID,licensePlate,kind , manufactureDay,lateGuaranteeDay,routeID,id) VALUES ";
	String INSERT_Bus_SQL = "INSERT INTO Bus"
			+ "  (busID,licensePlate,kind , manufactureDay,lateGuaranteeDay,routeID) VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public BusDAO() {

	}

	public int edit(BusDetails bus, String unitID) throws ClassNotFoundException, SQLException {
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
					"UPDATE Bus SET licensePlate = ?, kind= ?, manufactureDay= ?, lateGuaranteeDay= ?, routeID= ? WHERE BusID = ?;")) {
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
				insert.setString(1, bus.getLicensePlate());
				insert.setString(2, bus.getKind());
				insert.setDate(3,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(bus.getManufactureDay())));
				insert.setDate(4,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(bus.getLateGuaranteeDay())));
				insert.setInt(5, bus.getRouteID());
				insert.setString(6, unitID);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public int add(BusDetails bus) throws ClassNotFoundException, SQLException {
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
					.prepareStatement(INSERT_Bus_SQL + " (?,?,(N'" + bus.getKind() + "'),?,?,?);")) {
				// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
//				insert.executeUpdate();
				insert.setString(1, bus.getBusID());
				insert.setString(2, bus.getLicensePlate());
				insert.setDate(3,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(bus.getManufactureDay())));
				insert.setDate(4,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(bus.getLateGuaranteeDay())));
				insert.setInt(5, bus.getRouteID());
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
			ResultSet rs0 = stmt.executeQuery("select * from Bus WHERE BusID='" + id + "';");
			while (rs0.next()) {
				String busID = rs0.getNString("BusID");
				String licensePlate = rs0.getNString("licensePlate");
				String kind = rs0.getNString("kind");
				Date manufactureDay = rs0.getDate("manufactureDay");
				Date lateGuaranteeDay = rs0.getDate("lateGuaranteeDay");
				int routeID = rs0.getInt("routeID");

				try (PreparedStatement insert = con.prepareStatement(INSERT_BusTemp_SQL + " (?, ?, ?,?,?,?,?);")) {
					// 1private String accountID;
//			2private String accountName;
//			3private String password;
//			4private String fullName;
//			5private Date birthday;
//			6private String email;
//			7private String phoneNumber;
//			insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setString(1, busID);
					insert.setString(2, licensePlate);
					insert.setString(3, kind);
					insert.setDate(4,
							java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((manufactureDay))));
					insert.setDate(5,
							java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((lateGuaranteeDay))));
					insert.setInt(6, routeID);
					insert.setFloat(7, System.currentTimeMillis() + getMaxID());
//				int rs1 = insert.executeUpdate();

					insert.executeUpdate();
//					insert.close();
				}
				Statement stmt1 = con.createStatement();
				int rs2 = stmt1.executeUpdate("delete from Bus where busID='" + id + "';");
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
			ResultSet rs0 = stmt.executeQuery("select max(id) as maxID from BusTemp;");
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
			ResultSet rs0 = stmt.executeQuery("select * from BusTemp where id=(select max(id) from BusTemp);");
			while (rs0.next()) {
				String busID = rs0.getNString("BusID");
				String licensePlate = rs0.getNString("licensePlate");
				String kind = rs0.getNString("kind");
				Date manufactureDay = rs0.getDate("manufactureDay");
				Date lateGuaranteeDay = rs0.getDate("lateGuaranteeDay");
				int routeID = rs0.getInt("routeID");
				try (PreparedStatement insert = con.prepareStatement(INSERT_Bus_SQL + " (?, ?, ?,?, ?,?);")) {
					// 1private String accountID;
//		2private String accountName;
//		3private String password;
//		4private String fullName;
//		5private Date birthday;
//		6private String email;
//		7private String phoneNumber;
//		insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setString(1, busID);
					insert.setString(2, licensePlate);
					insert.setString(3, kind);
					insert.setDate(4,
							java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((manufactureDay))));
					insert.setDate(5,
							java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((lateGuaranteeDay))));
					insert.setInt(6, routeID);
//			int rs1 = insert.executeUpdate();

					insert.executeUpdate();
					insert.close();
				}
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate("delete from BusTemp where id=(select max(id) from BusTemp);");
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
//		System.out.println(new BusDAO().delete("bus015"));
//		new BusDAO().rollback();
		BusDetails busDetails = new BusDetails("bus016", "51B-043.21", "2 tầng", new Date(2010 - 1900, 2 - 1, 28),
				new Date(2015 - 1900, 3 - 1, 12), 3);
//		System.out.println(new BusDAO().add(busDetails));
		System.out.println(new BusDAO().edit(busDetails, "bus016"));
//		System.out.println(new BusDAO().getMaxID());

	}
}