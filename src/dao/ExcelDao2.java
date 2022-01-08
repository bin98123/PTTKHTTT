package dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ExcelDao2 extends Application {

	public void selectFile(Stage stage) {
		HBox root = new HBox();
		Scene scene = new Scene(root, 300, 300);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(stage);

		stage.setScene(scene);
		stage.show();
	}

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

	private void printCellDataToConsole(Vector dataHolder) {
		try {
			for (int i = 1; i < 8000; i++) {
				Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
				for (int j = 0; j < cellStoreVector.size(); j++) {
					HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
					String stringCellValue = myCell.toString();
					if (stringCellValue.equals("")) {
						break;
					} else {
						System.out.print(stringCellValue + "\t");
					}
					// Print Each cell here
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
//			HBox root = new HBox();
//			Scene scene = new Scene(root, 300, 300);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Microsoft Excel 97-2003 Worksheet", "*xls"));
		File file = fileChooser.showOpenDialog(stage);
		System.out.println(file.getAbsolutePath());
		// Read an Excel File from C:\\test.xls and Store in a Vector
		// Print the data read
//			stage.setScene(scene);
//			stage.show();
		Vector dataHolder = readExcelFile(file.getAbsolutePath());
//		// Print the data read
		printCellDataToConsole(dataHolder);
		dataHolder.clear();
	}

	public static void main(String[] args) {
		launch(args);
	}
}