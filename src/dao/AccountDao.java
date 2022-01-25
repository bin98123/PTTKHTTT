package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import model.AccountDetails;
import model.BusDetails;

public class AccountDao implements POI_API_DAO {
//	private String accountID;
//	private String accountName;
//	private String password;
//	private String fullName;
//	private Date birthday;
//	private String email;
//	private String phoneNumber;
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";
//	private String connectionUrl = "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
//			+ "databaseName=bin98123_PTTK;user=bin98123_PTTK;password=Khanhhuyen2410";
	String INSERT_ACCOUNT_SQL = "INSERT INTO Account"
			+ "  (accountID,accountName,password , fullName, birthday, email, phoneNumber) VALUES ";
	String INSERT_EXPIRE_SQL = "INSERT INTO expireTimeUser" + "  (accountName,expireHour,expireDate) VALUES ";
	String INSERT_LISTACCOUNTS_SQL = "INSERT INTO LoginUser" + "  (accountName,logining) VALUES ";
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
				chuyen.setID(rs.getInt("ID"));
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
		System.out.println(account);
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
//			try (PreparedStatement insert = connection
//					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, " + "(N'Quốc Khánh Trịnh Lê Ka')" + ", ?,?,?);")) {
			try (PreparedStatement insert = connection
					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, (N'" + account.getFullName() + "'), ?,?,?);")) {
				System.out.println(account.getFullName());
				// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
				insert.setString(1, getNumberID());
				insert.setString(2, account.getAccountName());
				insert.setString(3, account.getPassword());
//				insert.setNString(4, "N'" + account.getFullName() + "'");
				insert.setDate(4,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(account.getBirthday())));
				insert.setString(5, account.getEmail());
				insert.setString(6, account.getPhoneNumber());
//				insert.executeUpdate();
				result = insert.executeUpdate();
				insertListUser(account.getAccountName());

			}

		}
		return result;

	}

	public void setExpireTimeUser(String userName, java.sql.Time time, java.sql.Date date)
			throws ClassNotFoundException, SQLException {
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
			if (checkExistExpireTime(userName) == false) {
				try (PreparedStatement insert = connection.prepareStatement(INSERT_EXPIRE_SQL + " (?, ?,?);")) {
					insert.setString(1, userName);
					insert.setTime(2, time);
					insert.setDate(3, date);
					insert.executeUpdate();

				}
			} else if (checkExistExpireTime(userName) == true) {
				try (PreparedStatement insert = connection.prepareStatement(
						"UPDATE expireTimeUser SET expireHour = ?, expireDate = ? WHERE accountName = ?;")) {
					insert.setTime(1, time);
					insert.setDate(2, date);
					insert.setNString(3, userName);
					insert.executeUpdate();

				}

			}
		}

	}

	public boolean checkExistExpireTime(String userName) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from expireTimeUser where accountName='" + userName + "';");
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

	public java.sql.Time getExpireTime(String userName) {
		java.sql.Time available = null;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select expireHour from expireTimeUser where accountName='" + userName + "';");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				available = rs.getTime("expireHour");
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public void getAccounts() {
		String name;
		String pass;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account;");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				name = rs.getString("accountName");
				pass = rs.getString("password");
				System.out.println(name);
				System.out.println(pass);

//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}

	}

	public void getCountNumberOfAccounts() {
		int count = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(AccountID) as counts from Account;");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				count = rs.getInt("counts");
//				System.out.println(name);
				System.out.println(count);

//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}

	}

	public java.sql.Date getExpireDate(String userName) {
		java.sql.Date available = null;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select expireDate from expireTimeUser where accountName='" + userName + "';");
			while (rs.next()) {
				available = rs.getDate("expireDate");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public boolean getLogin(String userName, String userPassword) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select accountName, password from Account where accountName='" + userName
					+ "' and password='" + userPassword + "'");
			while (rs.next()) {
				loginUser(userName);
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

	public void insertListUser(String userName) throws ClassNotFoundException, SQLException {
//		Class.forName("org.hsqldb.jdbcDriver");
		int result = 0;
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
			try (PreparedStatement insert = connection.prepareStatement(INSERT_LISTACCOUNTS_SQL + " (?,?);")) {
				insert.setString(1, userName);
				insert.setBoolean(2, false);
				result = insert.executeUpdate();

			}

		}

	}

	public void loginUser(String userName) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{
//			if(checkLoginAccount(userName)==0) {
			try (PreparedStatement insert = connection
					.prepareStatement("UPDATE LoginUser SET logining = 1 WHERE accountName ='" + userName + "';")) {
				insert.executeUpdate();
				System.out.println("đã login!!!");

//			}
			}
		}

	}

	public void logoutUser(String userName) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{
			try (PreparedStatement insert = connection
					.prepareStatement("UPDATE LoginUser SET logining = 0 WHERE accountName ='" + userName + "';")) {
				insert.executeUpdate();

			}
		}

	}

	public void logoutUser() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{
			try (PreparedStatement insert = connection.prepareStatement("UPDATE LoginUser SET logining = 0;")) {
				insert.executeUpdate();

			}
		}

	}

	public void selectAccount() {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}

	}

	public String getPassword(String id) {
		String result = "";
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select password from Account where accountID='" + id + "';");
			while (rs.next()) {
				result = rs.getString("password");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return result;

	}

	public String getPasswordByMail(String email) {
		String result = null;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select password from Account where email='" + email + "';");
			while (rs.next()) {
				result = rs.getString("password");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return result;

	}
	public String getAccountNameByMail(String email) {
		String result = null;
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(connectionUrl);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select accountName from Account where email='" + email + "';");
			while (rs.next()) {
				result = rs.getString("accountName");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return result;
		
	}

	public boolean checkPassword(String passInput, String id) {
		if (passInput.equals(getPassword(id))) {
			return true;
		} else {

			return false;
		}

	}

	public AccountDetails getAccount(String userName, String userPassword) {
		AccountDetails available = new AccountDetails();
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from Account where accountName='" + userName + "' and password='" + userPassword + "'");
			while (rs.next()) {
				available.setAccountID(rs.getString("accountID"));
				available.setAccountName(rs.getString("accountName"));
				available.setPassword(rs.getString("password"));
				available.setFullName(rs.getNString("fullName"));
				available.setBirthday(rs.getDate("birthday"));
				available.setEmail(rs.getString("Email"));
				available.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public int checkAccount(String userName) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account where accountName='" + userName + "'");
			while (rs.next()) {
				available++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public int checkLoginAccount(String userName) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from LoginUser where accountName='" + userName + "' and logining= 0;");
			while (rs.next()) {
				available++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public AccountDetails getAccount(String id) {
		AccountDetails available = new AccountDetails();
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account where accountID='" + id + "'");
			while (rs.next()) {
				available.setAccountID(rs.getString("accountID"));
				available.setAccountName(rs.getString("accountName"));
				available.setPassword(rs.getString("password"));
				available.setFullName(rs.getNString("fullName"));
				available.setBirthday(rs.getDate("birthday"));
				available.setEmail(rs.getString("Email"));
				available.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

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

	public void editAccount(AccountDetails account, String id) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
//		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{

			// Step 3: Execute the query or update query
//			try {
//				Statement statement = connection.createStatement();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			String uName = user.getUserName();
//			String uIGName = user.getUserNameIG();
//			String uEmail = user.getUserEmail();

//			try (PreparedStatement insert = connection
//					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, " + "(N'Quốc Khánh Trịnh Lê Ka')" + ", ?,?,?);")) {
			try (PreparedStatement insert = connection.prepareStatement(
					"UPDATE Account SET fullName = ?, birthday= ?, email= ?, phoneNumber= ? WHERE accountID ='" + id
							+ "';")) {
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
				insert.setNString(1, account.getFullName());
				insert.setDate(2,
						java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(account.getBirthday())));
				insert.setString(3, account.getEmail());
				insert.setString(4, account.getPhoneNumber());
//				insert.executeUpdate();
				insert.executeUpdate();

			}
		}
	}

	public int changePassword(String pass, String id) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		int result = 0;
//		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		try (Connection connection = DriverManager.getConnection(connectionUrl))

		{

			// Step 3: Execute the query or update query
//			try {
//				Statement statement = connection.createStatement();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			String uName = user.getUserName();
//			String uIGName = user.getUserNameIG();
//			String uEmail = user.getUserEmail();

//			try (PreparedStatement insert = connection
//					.prepareStatement(INSERT_ACCOUNT_SQL + " (?, ?, ?, " + "(N'Quốc Khánh Trịnh Lê Ka')" + ", ?,?,?);")) {
			try (PreparedStatement insert = connection
					.prepareStatement("UPDATE Account SET password = ? WHERE accountID = ?;")) {
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
				insert.setString(1, pass);
				insert.setNString(2, id);
//				insert.executeUpdate();
				result = insert.executeUpdate();

			}

		}
		return result;

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

	public String getNumberID() {
		String result = "";
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

	// export excel file
	@Override
	public HSSFWorkbook getExportExel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		// sheet.addMergedRegion(new CellRangeAddress(0, //first row (0-based)
//		 		0, //last row (0-based)
//		 		0, //first column (0-based)
//		 		6 //last column (0-based)
		// ));
		HSSFCell cell = row.createCell(0);
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("accountID");
		cell = row.createCell(1);
		cell.setCellValue("accountName");
		cell = row.createCell(2);
		cell.setCellValue("password");
		cell = row.createCell(3);
		cell.setCellValue("fullName");
		cell = row.createCell(4);
		cell.setCellValue("birthday");
		cell = row.createCell(5);
		cell.setCellValue("email");
		cell = row.createCell(6);
		cell.setCellValue("phoneNumber");

		try {
			String accountID;
			String name;
			String pass;
			String fullName;
			Date birthday;
			String email;
			String phoneNumber;
			List<String> list = new ArrayList<String>();
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account;");
			int i = 1;
			while (rs.next()) {
				accountID = rs.getString("accountID");
				name = rs.getString("accountName");
				pass = rs.getString("password");
				fullName = rs.getString("fullName");
				birthday = rs.getDate("birthday");
				email = rs.getString("email");
				phoneNumber = rs.getString("phoneNumber");
				list.add(0, accountID);
				list.add(1, name);
				list.add(2, pass);
				list.add(3, fullName);
				list.add(4, "" + birthday);
				list.add(5, email);
				list.add(6, phoneNumber);

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
//		System.out.println(new SearchDAO().getSearch("Sài"));
//		System.out.println(new AccountDao().getAccount("an", "an"));
//		System.out.println(new AccountDao().getCount());
//		System.out.println(new AccountDao().registerUser(new AccountDetails("442", "khanhle", "12344",
//				"Hoàng Văn Thụ", new Date(1954, 3, 3), "ddsds@gmail.com", "13456")));
//		System.out.println(new AccountDao().getNumberID());
//		System.out.println(new AccountDao().getLogin("an", "an"));
//		new AccountDao().changePassword("huyenbeiu", "6");
//		new AccountDao().logoutUser();
		// System.out.println(new AccountDao().checkLoginAccount("khang"));
//		System.out.println(new AccountDao().checkExistExpireTime("khang"));
//		System.out.println(new AccountDao().getExpireDate("khang"));
//		System.out.println(new AccountDao().getExpireTime("khang"));
//		new AccountDao().getAccounts();
//		new AccountDao().getCountNumberOfAccounts();
//		new AccountDao().getPasswordByMail("18130112@st.hcmuaf.edu.vn");
		System.out.println(new AccountDao().getPasswordByMail("1813"));
		// new AccountDao().loginUser("khang");

//		System.out.println();
//		new AccountDao().selectAccount();
//		System.out.println(new AccountDao().getPassword("1624453300292"));
//		System.out.println(new AccountDao().checkPassword("huyen", "1624453300292"));
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
					AccountDao dao = new AccountDao();
					dao.registerUser(printCellDataToConsole(dataHolder, fileName).get(j));
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

	private List<AccountDetails> printCellDataToConsole(Vector dataHolder, String fileName) throws IOException {
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
		List<AccountDetails> ListBusDetails = new ArrayList<AccountDetails>();
		AccountDetails busDetails = new AccountDetails();
		List<String> containListBus = new ArrayList<String>();
		try {

			for (int i = 1; i < rowTotal; i++) {
				Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
				for (int j = 0; j < cellStoreVector.size(); j++) {
					HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
					String stringCellValue = myCell.toString();
//					System.out.print(stringCellValue + "\t");
					containListBus.add(j, stringCellValue);
					// Print Each cell here

				}
				AccountDao dao = new AccountDao();
				if (dao.checkAccount(containListBus.get(1)) == 0) {
					busDetails = new AccountDetails(containListBus.get(0), containListBus.get(1), containListBus.get(2),
							containListBus.get(3), java.sql.Date.valueOf((containListBus.get(4))),
							containListBus.get(5), containListBus.get(6));
				}
				ListBusDetails.add(i - 1, busDetails);
				busDetails = new AccountDetails();
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