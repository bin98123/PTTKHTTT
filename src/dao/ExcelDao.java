package dao;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDao {
	public static void main(String[] args) throws IOException {
		new ExcelDao().writeExcel();
	}

	public void readExcel() {

	}

	public void writeExcel() throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\quockhanh156\\Desktop\\data.xlsx");
//		FileOutputStream file = new FileOutputStream("data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("number");
		XSSFRow row;
		XSSFCell cellA;
		XSSFCell cellB;
		for (int i = 0; i < 10; i++) {
			row = sheet.createRow((short) i);
			cellA = row.createCell((short) 0);
			cellA.setCellValue(i + 1);
			cellB = row.createCell((short) 1);
			cellB.setCellValue(i + 2);
		}
		workbook.write(file);
		workbook.close();
		file.close();
	}
}
