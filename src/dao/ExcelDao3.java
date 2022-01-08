package dao;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Point;

public class ExcelDao3 extends Component {

	Point pLocation = new Point(100, 100);
	// Dimension dSize = new Dimension(500,400) ;
	boolean bLog = false;
	Frame fm = new Frame();

	/*
	 * Show an Open file dialog
	 */
	public String openFile(String title, String defDir, String fileType) {

		String sFile = "";

		log("title:" + title);
		log("defdir:" + defDir);
		log("filetype:" + fileType);

		fm.setLocation(pLocation);
		FileDialog fd = new FileDialog(fm, title, FileDialog.LOAD);
		fd.setFile(fileType);
		fd.setDirectory(defDir);
		fd.setResizable(true);
		fd.setVisible(true);
		fd.show();
		if (fd.getFile() != null)
			sFile = fd.getDirectory() + fd.getFile();
		// sFile = fd.getDirectory() + System.getProperty("file.separator") +
		// fd.getFile();
		return sFile;
	}

	/*
	 * Show a Save file dialog
	 */
	public String saveFile(String title, String defDir, String fileType) {

		String sFile = "";

		log("title:" + title);
		log("defdir:" + defDir);
		log("filetype:" + fileType);

		fm.setLocation(pLocation);
		FileDialog fd = new FileDialog(fm, title, FileDialog.SAVE);
		fd.setFile(fileType);
		fd.setDirectory(defDir);
		fd.show();
		if (fd.getFile() != null)
			sFile = fd.getDirectory() + fd.getFile();
		// sFile = fd.getDirectory() + System.getProperty("file.separator") +
		// fd.getFile();
		return sFile;

	}

	public void setLog(boolean b) {
		bLog = b;
	}

	void log(String sMessage) {
		if (bLog)
			System.out.println(sMessage);
	}

	public static void main(String[] args) {
		new ExcelDao3();
	}
}