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
import java.util.ArrayList;
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

import model.BusUnitManagerDetails;
import model.DriverDetails;

public class UnitDAO implements POI_API_DAO {
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

	public int checkExist(BusUnitManagerDetails busDetails) {
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
					.executeQuery("select * from BusUnitManager where unitID ='" + busDetails.getUnitID() + "';");
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

	public int add(BusUnitManagerDetails unitDetails) throws ClassNotFoundException, SQLException {
		int result = 0;
//		Class.forName("org.hsqldb.jdbcDriver");
		Class.forName(driver);
		if (checkExist(unitDetails) == 0) {
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
				try (PreparedStatement insert = connection.prepareStatement(INSERT_BusUnitManager_SQL + " ((N'"
						+ unitDetails.getUnitID() + "'),(N'" + unitDetails.getUnitName() + "'),(N'"
						+ unitDetails.getPhoneNumber() + "'),(N'" + unitDetails.getEmail() + "'));")) {
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

	// export excel file
	@Override
	public HSSFWorkbook getExportExel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("unitID");
		cell = row.createCell(1);
		cell.setCellValue("unitName");
		cell = row.createCell(2);
		cell.setCellValue("phoneNumber");
		cell = row.createCell(3);
		cell.setCellValue("Email");

		try {
			String unitID;
			String unitName;
			String phoneNumber;
			String Email;
			List<String> list = new ArrayList<String>();
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PTTK;user=sa;password=root";

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from BusUnitManager;");
			int i = 1;
			while (rs.next()) {
				unitID = rs.getString("unitID");
				unitName = rs.getString("unitName");
				phoneNumber = rs.getString("phoneNumber");
				Email = rs.getString("Email");
				list.add(0, "" + unitID);
				list.add(1, "" + unitName);
				list.add(2, "" + phoneNumber);
				list.add(3, "" + Email);

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
					UnitDAO dao = new UnitDAO();
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

	private List<BusUnitManagerDetails> printCellDataToConsole(Vector dataHolder, String fileName) throws IOException {
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
		List<BusUnitManagerDetails> ListBusDetails = new ArrayList<BusUnitManagerDetails>();
		BusUnitManagerDetails busDetails = new BusUnitManagerDetails();
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
				busDetails = new BusUnitManagerDetails(containListBus.get(0), containListBus.get(1),
						containListBus.get(2), containListBus.get(3));
				ListBusDetails.add(i - 1, busDetails);
				busDetails = new BusUnitManagerDetails();
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
//		System.out.println(new BusDAO().deleteUnit("u18"));
//		new BusDAO().rollback();
//		BusUnitManagerDetails unitDetails = new BusUnitManagerDetails("u19", "Khanh", "878787", "khanh@gmail.com");
//		System.out.println(new BusDAO().add(unitDetails));
		System.out.println(new UnitDAO().getMaxID());

	}

}