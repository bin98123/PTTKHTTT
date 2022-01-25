package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.BusDetails;

public class BusDAO implements POI_API_DAO {
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

	public List<BusDetails> getBusesList() {
		List<BusDetails> result = new ArrayList<BusDetails>();
		List<BusDetails> chuyens = new ArrayList<BusDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus");
			while (rs.next()) {
				BusDetails chuyen = new BusDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
				chuyen.setBusID(rs.getNString("BusID"));
				chuyen.setLicensePlate(rs.getNString("licensePlate"));
				chuyen.setKind(rs.getNString("kind"));
				chuyen.setManufactureDay(rs.getDate("ManufactureDay"));
				chuyen.setLateGuaranteeDay(rs.getDate("LateGuaranteeDay"));
				chuyen.setRouteID(rs.getInt("RouteID"));
//				System.out.println(rs.getInt("STT"));
//				chuyen.setTemTram(rs.getNString("nameBusStop"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
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

	public int getCountNumberOfBus() {
		int count = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(busID) as counts from Bus;");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				count = rs.getInt("counts");
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

	public void getBuses() {
		String busID;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus;");
			while (rs.next()) {
//				if (rs.getTime("expireHour") == null) {
//					available = new java.sql.Time(23, 0, 0);
//				} else if (rs.getTime("expireHour") != null) {
				busID = rs.getString("busID");
				System.out.println(busID);

//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}

	}

	public int checkExist(BusDetails busDetails) {
		int count = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus where busID like '" + busDetails.getBusID() + "';");
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

	public int add(BusDetails bus) throws ClassNotFoundException, SQLException {
		int result = 0;
//		Class.forName("org.hsqldb.jdbcDriver");
		Class.forName(driver);
//		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		if (checkExist(bus) == 0) {
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
					insert.setDate(4, java.sql.Date
							.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(bus.getLateGuaranteeDay())));
					insert.setInt(5, bus.getRouteID());
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
			String INSERT_BusStopTemp = "INSERT INTO BusTemp"
					+ "  (busID,licensePlate,kind , manufactureDay,lateGuaranteeDay,routeID)";
			try (PreparedStatement insert = con.prepareStatement(INSERT_BusStopTemp
					+ " SELECT busID,licensePlate,kind , manufactureDay,lateGuaranteeDay,routeID from Bus;")) {
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
			try {
				PreparedStatement insert1 = con

						.prepareStatement("UPDATE BusTemp " + "SET id = " + currentTime + "where id is null;");
				insert1.executeUpdate();
				con.commit();
			} catch (Exception e) {
				if (con != null)
					con.rollback();
			}

			Statement stmt1 = con.createStatement();
			int rs2 = stmt1.executeUpdate("delete from Bus;");
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

	public List<BusDetails> getBusID() {
		List<BusDetails> result = new ArrayList<BusDetails>();
		List<BusDetails> chuyens = new ArrayList<BusDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select distinct BusID from Bus");
			while (rs.next()) {
				BusDetails chuyen = new BusDetails();
//				available++;
//				System.out.println("Khanh");
//				chuyen.setID(rs.getFloat("ID"));
////				System.out.println(rs.getFloat("ID"));
//				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setBusID(rs.getNString("BusID"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
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

	// export excel file
	@Override
	public HSSFWorkbook getExportExel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("busID");
		cell = row.createCell(1);
		cell.setCellValue("licensePlate");
		cell = row.createCell(2);
		cell.setCellValue("kind");
		cell = row.createCell(3);
		cell.setCellValue("manufactureDay");
		cell = row.createCell(4);
		cell.setCellValue("lateGuaranteeDay");
		cell = row.createCell(5);
		cell.setCellValue("routeID");

		try {
			String busID;
			String licensePlate;
			String kind;
			Date manufactureDay;
			Date lateGuaranteeDay;
			int routeID;
			List<String> list = new ArrayList<String>();
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Bus;");
			int i = 1;
			while (rs.next()) {
				busID = rs.getString("busID");
				licensePlate = rs.getString("licensePlate");
				kind = rs.getString("kind");
				manufactureDay = rs.getDate("manufactureDay");
				lateGuaranteeDay = rs.getDate("lateGuaranteeDay");
				routeID = rs.getInt("routeID");
				list.add(0, busID);
				list.add(1, licensePlate);
				list.add(2, kind);
				list.add(3, "" + manufactureDay);
				list.add(4, "" + lateGuaranteeDay);
				list.add(5, "" + routeID);

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
//		System.out.println(new BusDAO().delete("bus015"));
//		new BusDAO().rollback();
//		BusDetails busDetails = new BusDetails("bus016", "51B-043.21", "2 tầng", new Date(2010 - 1900, 2 - 1, 28),
//				new Date(2015 - 1900, 3 - 1, 12), 3);
////		System.out.println(new BusDAO().add(busDetails));
//		System.out.println(new BusDAO().edit(busDetails, "bus016"));
////		System.out.println(new BusDAO().getMaxID());
//		System.out.println(new BusDAO().getCountNumberOfBus());
//		System.out.println("kiểm tra đã tồn tại: " + new BusDAO().checkExist(busDetails));
//		new BusDAO().getBuses();
		System.out.println(new BusDAO().deleteAll());
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
					BusDAO dao = new BusDAO();
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

	private List<BusDetails> printCellDataToConsole(Vector dataHolder, String fileName) throws IOException {
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
		List<BusDetails> ListBusDetails = new ArrayList<BusDetails>();
		BusDetails busDetails = new BusDetails();
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
				busDetails = new BusDetails(containListBus.get(0), containListBus.get(1), containListBus.get(2),
						java.sql.Date.valueOf((containListBus.get(3))), java.sql.Date.valueOf((containListBus.get(4))),
						Integer.parseInt(containListBus.get(5)));
				ListBusDetails.add(i - 1, busDetails);
				busDetails = new BusDetails();
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