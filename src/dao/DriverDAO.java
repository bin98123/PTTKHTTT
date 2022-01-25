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

import model.AccountDetails;
import model.BusRouteDetails;
import model.DriverDetails;

public class DriverDAO implements POI_API_DAO {
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
	public List<DriverDetails> getDriver() {
		List<DriverDetails> result = new ArrayList<DriverDetails>();
		List<DriverDetails> chuyens = new ArrayList<DriverDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Driver");
			while (rs.next()) {
				DriverDetails chuyen = new DriverDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setDriverID(rs.getNString("DriverID"));
				chuyen.setFullName(rs.getNString("FullName"));
				chuyen.setBirthday(rs.getDate("Birthday"));
				chuyen.setMale(rs.getBoolean("Male"));
				chuyen.setAddress(rs.getNString("Address"));
				chuyen.setCountry(rs.getNString("Country"));
				chuyen.setDayBegin(rs.getDate("DayBegin"));
				chuyen.setSalary(rs.getInt("Salary"));
				chuyen.setDriverLicense(rs.getNString("DriverLicense"));
				chuyen.setBusID(rs.getNString("BusID"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
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

	public float getMaxID() throws SQLException, ClassNotFoundException {
		float result = 0;
//		select * from BusUnitManagerTemp where id=(select max(id) from BusUnitManagerTemp);
		Connection con = DriverManager.getConnection(connectionUrl);

		Statement stmt = con.createStatement();
		con.setAutoCommit(false);
		try {

			Class.forName(driver);
			ResultSet rs0 = stmt.executeQuery("select max(id) as maxID from DriverTemp;");
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

	public int checkExist(DriverDetails busDetails) {
		int count = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			System.out.println(busDetails);
//			ResultSet rs = stmt.executeQuery("select * from BusStop where nameBusStop like '" + busDetails.getNameBusStop()
//				+ "'");
//			cxcxcx
			ResultSet rs = stmt
					.executeQuery("select * from Driver where driverID ='" + busDetails.getDriverID() + "';");
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

	public int add(DriverDetails driverDetails) throws ClassNotFoundException, SQLException {
		int result = 0;
		System.out.println(driverDetails);
//		Class.forName("org.hsqldb.jdbcDriver");
		Class.forName(driver);
		if (checkExist(driverDetails) == 0) {
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
					insert.setDate(1, java.sql.Date
							.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getBirthday())));
					insert.setBoolean(2, driverDetails.getMale());
//				insert.setNString(4, "N'" + account.getFullName() + "'");
					insert.setDate(3, java.sql.Date
							.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(driverDetails.getDayBegin())));
					insert.setInt(4, driverDetails.getSalary());
//				insert.executeUpdate();
					result = insert.executeUpdate();

				}

			}
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
			String INSERT_BusStopTemp = "INSERT INTO DriverTemp" + "  (driverID , fullName , birthday , male , address , country, dayBegin, salary, driverLicense, BusID)";
			try (PreparedStatement insert = con
					.prepareStatement(INSERT_BusStopTemp + " SELECT driverID , fullName , birthday , male , address , country, dayBegin, salary, driverLicense, BusID from Driver;")) {
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
					.prepareStatement("UPDATE DriverTemp " + "SET id = " + currentTime + "where id is null;");
			insert1.executeUpdate();
			con.commit();
			if (con != null)
				con.rollback();
			////
			
			Statement stmt1 = con.createStatement();
			int rs2 = stmt1.executeUpdate("delete from Driver;");
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
					insert.setFloat(11, System.currentTimeMillis() + getMaxID());
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

	// export excel file
	@Override
	public HSSFWorkbook getExportExel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("driverID");
		cell = row.createCell(1);
		cell.setCellValue("fullName");
		cell = row.createCell(2);
		cell.setCellValue("birthday");
		cell = row.createCell(3);
		cell.setCellValue("male");
		cell = row.createCell(4);
		cell.setCellValue("address");
		cell = row.createCell(5);
		cell.setCellValue("country");
		cell = row.createCell(6);
		cell.setCellValue("dayBegin");
		cell = row.createCell(7);
		cell.setCellValue("salary");
		cell = row.createCell(8);
		cell.setCellValue("driverLicense");
		cell = row.createCell(9);
		cell.setCellValue("BusID");
		cell = row.createCell(10);

		try {
			String driverID;
			String fullName;
			Date birthday;
			boolean male;
			String address;
			String country;
			Date dayBegin;
			int salary;
			String driverLicense;
			String BusID;
			List<String> list = new ArrayList<String>();
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Driver;");
			int i = 1;
			while (rs.next()) {
				driverID = rs.getString("driverID");
				fullName = rs.getString("fullName");
				birthday = rs.getDate("birthday");
				male = rs.getBoolean("male");
				address = rs.getString("address");
				country = rs.getString("country");
				dayBegin = rs.getDate("dayBegin");
				salary = rs.getInt("salary");
				driverLicense = rs.getString("driverLicense");
				BusID = rs.getString("BusID");
				list.add(0, "" + driverID);
				list.add(1, "" + fullName);
				list.add(2, "" + birthday);
				list.add(3, "" + male);
				list.add(4, "" + address);
				list.add(5, "" + country);
				list.add(6, "" + dayBegin);
				list.add(7, "" + salary);
				list.add(8, "" + driverLicense);
				list.add(9, "" + BusID);

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
					DriverDAO dao = new DriverDAO();
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

	private List<DriverDetails> printCellDataToConsole(Vector dataHolder, String fileName) throws IOException {
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
		List<DriverDetails> ListBusDetails = new ArrayList<DriverDetails>();
		DriverDetails busDetails = new DriverDetails();
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
				boolean male = false;
				String maleData = containListBus.get(3);
				if (maleData.equalsIgnoreCase("true")) {
					male = true;
				}
				busDetails = new DriverDetails(containListBus.get(0), containListBus.get(1),
						java.sql.Date.valueOf(containListBus.get(2)), male, containListBus.get(4),
						containListBus.get(5), java.sql.Date.valueOf(containListBus.get(6)),
						Integer.parseInt(containListBus.get(7)), (containListBus.get(8)), (containListBus.get(9)));

				ListBusDetails.add(i - 1, busDetails);
				busDetails = new DriverDetails();
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
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(new DriverDAO().deleteDriver("d01"));
//		new DriverDAO().rollback();
//		DriverDetails driverDetails = new DriverDetails(null, "Lê Thành Nam", new Date(1970, 8, 30), true, "Huế",
//				"Việt Nam", new Date(2017, 1, 28), 11000000, "843877483", "bus003");
//		System.out.println(new DriverDAO().edit(driverDetails, "d01"));

	}

}