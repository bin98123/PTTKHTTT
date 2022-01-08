package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface POI_API_DAO {
	HSSFWorkbook getExportExel();

	void selectFile() throws IOException, ClassNotFoundException, SQLException;

	Vector readExcelFile(String fileName);
	
}
