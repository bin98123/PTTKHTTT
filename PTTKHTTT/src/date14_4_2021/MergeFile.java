package date14_4_2021;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeFile {
	FileInputStream fis;
	FileOutputStream fos;
	DataInputStream dis;
	OutputStreamWriter osw;
	InputStreamReader isr;
	BufferedOutputStream bos;

	File file = new File("H:\\Năm 3 HK2\\PTTK HTTT\\line\\New folder\\New folder");
	File[] file_Names;
	int i = 0, ltc, file_Size, count_Files; // ltc=Length to copy till how many bytes
	byte[] rw_Buffer, con_Str_Bt_Arr;
	int size;

	MergeFile() throws Exception {
		System.out.println("Enter into MergeFile  method");
		file_Names = file.listFiles();
		if (file_Names != null) {
			System.out.println("got file names frm " + file + " folder ");
		}

		count_Files = file_Names.length;
		System.out.println("the total number of files in the path " + file + " : " + count_Files);
		System.out.println("File names: ");

		for (int i = 0; i < file_Names.length; i++) {
			System.out.println(file_Names[i] + "\t");
		}

		if (count_Files != 0) {
			System.out.println("got file number  \n");
		}

		System.out.println("The number of files in the input folder to merge  " + count_Files + "\n");

		fos = new FileOutputStream("H:\\Năm 3 HK2\\PTTK HTTT\\line\\data1.txt"); // outputs file file location stores
		if (fos != null) {
			System.out.println("fos created " + fos);
		}

		bos = new BufferedOutputStream(fos);
		osw = new OutputStreamWriter(fos, "UTF-8");
		if (bos != null) {
			System.out.println("bos created " + bos);
		}

		size = 0;
		rw_Buffer = new byte[999000]; // read and write buffer size
		if (rw_Buffer != null) {
			System.out.println("byte array created " + rw_Buffer);
		}

		int sl;
		while (count_Files > 0) {
			System.out.println("Entring into while loop");
			String scrFile = file_Names[i].getName();
			System.out.println("<<<<<----->>" + scrFile);

			if (scrFile != null) {
				System.out.println("the file name is " + scrFile);
			}

			fis = new FileInputStream("H:\\Năm 3 HK2\\PTTK HTTT\\line\\New folder\\New folder\\" + scrFile);
			if (fis != null) {
				System.out.println("fis is " + fis);
			}

			dis = new DataInputStream(fis);
			if (dis != null) {
				System.out.println("dis is " + dis);
			}

			sl = scrFile.length();
			if (sl != 0) {
				System.out.println("sl is " + sl);
			}

			bos.write(sl);
			if (bos != null) {
				System.out.println("bos is written   " + bos);
			} else {
				System.out.println("bos not  written" + bos);
			}
//			con_Str_Bt_Arr = scrFile.getBytes("utf-8"); // convetting file name in string to byte array
			con_Str_Bt_Arr = scrFile.getBytes(); // convetting file name in string to byte array
			if (con_Str_Bt_Arr != null) {
				System.out.println("con_Str_Bt_Arr soruce file is conveted to bytes   " + con_Str_Bt_Arr);
			} else {
				System.out.println("con_Str_Bt_Arr soruce file not conveted to bytes   " + con_Str_Bt_Arr);
			}
			ltc = con_Str_Bt_Arr.length; // name lenght

//			bos.write(con_Str_Bt_Arr, 0, ltc); // adding file name to *.dat file
			file_Size = dis.available(); // content size in file
//			bos.write(file_Size); // adding content size
			size = size + file_Size;
			System.out.println("----------->>>>" + size);
			file_Size = dis.available();
			dis.readFully(rw_Buffer, 0, file_Size); // reading data from files in bytes
//			dis.readUTF();
			System.out.println("->>> dis.readFully");
//			osw.write(file_Size);
			bos.write(rw_Buffer, 0, file_Size); // writing data to files in bytes
//			osr.write(rw_Buffer, 0, file_Size); // writing data to files in bytes
//			osr.w
			size = size + file_Size;
			count_Files--;
			i++;
		}
		close();

		return;
	}

	public void close() throws Exception {
		bos.flush();
		bos.close();
		fos.close();

	}

	public static void main(String[] args) throws Exception {
		System.out.println("enter main \n");
		new MergeFile();
		System.out.println("exit main  \n");
	}
}