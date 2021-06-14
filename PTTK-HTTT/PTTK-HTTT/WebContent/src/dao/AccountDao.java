package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.AccountDetails;
import model.AccountDetails1;

public class AccountDao {
//	private String accountID;
//	private String accountName;
//	private String password;
//	private String fullName;
//	private Date birthday;
//	private String email;
//	private String phoneNumber;
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
	String INSERT_ACCOUNT_SQL = "INSERT INTO Account1"
			+ "  (accountName,password , fullName, birthday, email, phoneNumber) VALUES ";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public List<ChuyenDetails> getSearch(String txtSearch) {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Chuyen where ID like N'%" + txtSearch + "%' or STT like N'%"
					+ txtSearch + "%' or TenTram like N'%" + txtSearch + "%'");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
				chuyen.setID(rs.getFloat("ID"));
				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("TenTram"));
				chuyens.add(chuyen);
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return chuyens;

	}

	public int registerUser(AccountDetails account) throws ClassNotFoundException, SQLException {
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

//			String accountID = "" + getCount();
			try (PreparedStatement insert = connection
					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, N'" + account.getFullName() + "', ?,?,?);")) {
//				1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
//				insert.setInt(1, 1);
				insert.setString(1, account.getAccountName());
				insert.setString(2, account.getPassword());
//				insert.setNString(4, "N'" + account.getFullName() + "'");
				insert.setDate(3,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(account.getBirthday())));
				insert.setString(4, account.getEmail());
				insert.setString(5, account.getPhoneNumber());
//				insert.executeUpdate();
				result = insert.executeUpdate();
				insert.close();
				connection.close();

			}

		}
		return result;

	}

	public int registerUser1(AccountDetails1 account) throws ClassNotFoundException, SQLException {
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

			int accountID = getCount();
			try (PreparedStatement insert = connection
					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, N'" + account.getFullName() + "', ?,?,?);")) {
//				1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
				insert.setInt(1, getNumberID());
				insert.setString(2, account.getAccountName());
				insert.setString(3, account.getPassword());
//				insert.setNString(4, "N'" + account.getFullName() + "'");
				insert.setDate(4,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(account.getBirthday())));
				insert.setString(5, account.getEmail());
				insert.setString(6, account.getPhoneNumber());
				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

	}

	public boolean getLogin(String userName, String userPassword) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select accountName, password from Account1 where accountName='" + userName
					+ "' and password='" + userPassword + "'");
			while (rs.next()) {
				available++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		if (available != 0) {
			return true;
		}
		return false;

	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public boolean checkUpdate() throws SQLException {
		Connection connection = DriverManager.getConnection(connectionUrl);
		PreparedStatement stmt = connection.prepareStatement(INSERT_ACCOUNT_SQL);
		int i = stmt.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getNumberID() {
		int result = 0;
		Calendar now = Calendar.getInstance();
		int date = now.get(Calendar.DATE);
		int month = now.get(Calendar.MONTH);
		int year = now.get(Calendar.YEAR);
//		result += (System.currentTimeMillis() + date + month + year);
		result += (System.currentTimeMillis());
		return result;
	}

	public int getCount() {
		int result = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select count(accountID) as number from Account");
//			ResultSet rs = stmt.executeQuery("select count(rownum) as total from Account");
			ResultSet rs = stmt.executeQuery("select count(Email) as totalRow from Account1");
//			ResultSet rs = stmt.executeQuery("select count(*) as total from Account");
//			ResultSet rs = stmt.executeQuery("select * from Account");
			while (rs.next()) {
//				result++;
				result = rs.getInt("totalRow");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return result + 1;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(new SearchDAO().getSearch("Sài"));
//		System.out.println(new AccountDao().getCount());
//		System.out.println(new AccountDao().registerUser(new AccountDetails("442", "khanhle", "12344",
//				"Hoàng Văn Thụ", new Date(1954, 3, 3), "ddsds@gmail.com", "13456")));
		System.out.println(new AccountDao().getNumberID());
	}
}