package dao;

import java.io.File;
import jxl.Workbook;
import jxl.write.*;

public class Write_to_excel_file_directly {
	public static void main(String[] args) throws InterruptedException {
		WritableWorkbook wworkbook;
		try {
			wworkbook = Workbook.createWorkbook(new File("H:\\test.xls"));
			// Sheet name
			WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
			int i = 0;
			int j = 1;
			i = 0;
			// row 1
			Label label = new Label(i++, j, j + "");
			wsheet.addCell(label);
			label = new Label(i++, j, "11");
			wsheet.addCell(label);
			label = new Label(i++, j, "12");
			wsheet.addCell(label);
			label = new Label(i++, j, "13");
			wsheet.addCell(label);
			j++;
			// row 2
			i = 0;
			label = new Label(i++, j, j + "");
			wsheet.addCell(label);
			label = new Label(i++, j, "21");
			wsheet.addCell(label);
			label = new Label(i++, j, "22");
			wsheet.addCell(label);
			label = new Label(i++, j, "33");
			wsheet.addCell(label);
			j++;
			wworkbook.write();
			wworkbook.close();
			System.out.println("fineshed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}