package date5_4_2021;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LoadFile {
	public static void main(String[] args) throws IOException {

//		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\88_back.txt";
//		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\line";
		String path0 = "H:\\Năm 3 HK2\\PTTK HTTT\\line\\data_distinct.txt";
		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\New folder\\93_back.txt";
//		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path, true);
//		BufferedReader osw = new BufferedReader(fos);
		File f = new File(path0);
//		File[] folder = f.listFiles();
//		for (File listf : folder) {
//			for (int i = 0; i < folder.length; i++) {
		FileInputStream file = new FileInputStream(f);
//		BufferedInputStream bis = new BufferedInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(file);
//		InputStreamReader osw = new InputStreamReader(bis, "UTF-16");
//		InputStreamReader osw = new InputStreamReader(fos, "UTF-8");
//		InputStreamReader osw = new InputStreamReader(bis, "UTF-16");
//				DataInputStream dataInputStream = new DataInputStream(fis);
		InputStreamReader isr = new InputStreamReader(file, "UTF-8");
//				OutputStreamWriter osr = new OutputStreamWriter(fos, "UTF-8");
//		PrintWriter pw = new PrintWriter(new File(path));
//		System.out.println(pw);
//		InputStreamReader osw = new InputStreamReader(bis, "ISO-8859-1");
		int s;
		String result = "";
		byte[] buffer = new byte[1024 * 100];
		while ((s = isr.read()) != -1) {
			fos.write(buffer, 0, s);
//			String encodedValue2 = URLEncoder.encode(crunchifyValue2, "UTF-8");
//			System.out.print((char) s);
			result += (char) s;
//					System.out.print(s);

		}
//				System.out.println("------------------------------------------");
//		System.out.print(result);
		int count = 0;
		StringTokenizer tokenizer = new StringTokenizer(result, "\n");
		int countLine = tokenizer.countTokens();

		for (int j = 0; j < countLine; j++) {
//		for (int j = 0; j < tokenizer.countTokens(); j++) {
//					count = folder.length;
			String a = "";
//			String b = a.replace("\n", "");
//					if (tokenizer.hasMoreTokens()) {
			// dòng tô màu là thứ tự thằng cuối trong bảng đang có + 1, i là đang tăng lên
			// bắt đầu từ 0
			// lúc đầu thằng cuối là 231 nên phải ghi 232, i là cho giá trị nó tăng lên mỗi
			// lần lặp
			a = "insert into Tram values(" + (j + count) + ",N'" + tokenizer.nextToken().trim() + "')";
//			a = tokenizer.nextToken().trim();
			// trim()
			// để
			// cắt
			// dòng
			// line
//					}
			System.out.println(a);
		}
		bis.close();
		file.close();
		fos.close();
//
//			}
	}

}
//}