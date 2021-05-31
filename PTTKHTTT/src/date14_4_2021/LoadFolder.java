package date14_4_2021;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LoadFolder {

	public static void main(String[] args) throws IOException {

//		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\line\\104_go.txt";
		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\line";
//		String path = "H:\\Năm 3 HK2\\PTTK HTTT\\line";
		String path0 = "H:\\Năm 3 HK2\\PTTK HTTT\\line\\data1.txt";
//		String path0 = "H:\\Năm 3 HK2\\PTTK HTTT\\line\\data.txt";
//			String path = "H:\\Năm 3 HK2\\PTTK HTTT\\New folder\\93_back.txt";
//			FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path0, true);
//		BufferedReader osw = new BufferedReader(fos);
		File f = new File(path);
		File[] folder = f.listFiles();
		for (File listf : folder) {
			if (listf.getAbsolutePath().endsWith("txt")) {
				while (listf.exists()) {
//			File f0 = new File(listf.getAbsoluteFile());
					FileInputStream file = new FileInputStream(listf);
					BufferedInputStream bis = new BufferedInputStream(file);
					InputStreamReader isr = new InputStreamReader(file, "UTF-8");
//			FileInputStream file = new FileInputStream(listf.getAbsolutePath());
//			if (listf.exists() && listf.isFile() && listf.getAbsolutePath().endsWith("txt")) {
//			for (int i = 0; i < folder.length; i++) {
//		FileInputStream file = new FileInputStream(path);
//			BufferedInputStream bis = new BufferedInputStream(path);
//				BufferedInputStream bis = new BufferedInputStream(file);
//			InputStreamReader osw = new InputStreamReader(bis, "UTF-16");
//			InputStreamReader osw = new InputStreamReader(fos, "UTF-8");
//			InputStreamReader osw = new InputStreamReader(bis, "UTF-16");
//					DataInputStream dataInputStream = new DataInputStream(fis);
//			InputStreamReader isr = new InputStreamReader(file, "UTF-8");
//				OutputStreamWriter osr = new OutputStreamWriter(fos, "UTF-8");
//			PrintWriter pw = new PrintWriter(new File(path));
//			System.out.println(pw);
//			int s;
					String result = "";
					int s;
//				String result = "";
					byte[] buffer = new byte[1024 * 10000];
					while ((s = file.read(buffer)) != -1) {
						fos.write(buffer, 0, s);
//			String encodedValue2 = URLEncoder.encode(crunchifyValue2, "UTF-8");
//			System.out.print((char) s);
//						result += (char) s;
//				System.out.print(s);
					}
					if (listf.isFile() && listf.getAbsolutePath().endsWith("txt")) {
						listf.delete();
					}
//					System.out.println("------------------------------------------");
//			System.out.print(result);
//				int count = 644;
//				StringTokenizer tokenizer = new StringTokenizer(result, "\n");
//				for (int j = 0; j < tokenizer.countTokens() + 100; j++) {
////						count = folder.length;
//					String a = "";
////				String b = a.replace("\n", "");
////						if (tokenizer.hasMoreTokens()) {
//					// dòng tô màu là thứ tự thằng cuối trong bảng đang có + 1, i là đang tăng lên
//					// bắt đầu từ 0
//					// lúc đầu thằng cuối là 231 nên phải ghi 232, i là cho giá trị nó tăng lên mỗi
//					// lần lặp
//					a = "insert into Tram values(" + (j + count) + ",N'" + tokenizer.nextToken().trim() + "')";// trim()
//																												// để
//																												// cắt
//																												// dòng
//																												// line
////						}
//					System.out.println(a);
//				}
//				bis.close();

//			}
					bis.close();
					file.close();
					fos.close();
					System.out.println("Done!!!");
				}
			}
		}
	}

}