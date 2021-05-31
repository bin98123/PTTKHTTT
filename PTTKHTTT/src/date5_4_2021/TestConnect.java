package date5_4_2021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnect {
	public static void main(String[] args) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Shop;user=sa;password=root";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(connectionUrl);
			Statement stat = connection.createStatement();
//			String sql = "SELECT CacTuyenXeBuyt FROM DonViDamNhan where TenDonVi = N'Công ty Cổ phần Xe khách Sài Gòn'";
//			String sql = "SELECT TenDonVi FROM DonViDamNhan where CacTuyenXeBuyt = '120'";
//			String sql = "SELECT TENDIEMDUNG FROM TRAM where TRAMID = 50";
			String sql = "SELECT * FROM Chuyen";
//			String sql = "SELECT * FROM DonViDamNhan";
			ResultSet res = stat.executeQuery(sql);

			while (res.next()) {

//				System.out.print(res.getNString("TENDIEMDUNG"));
//				System.out.print(res.getString("CacTuyenXeBuyt"));
//				System.out.printf("%s\t|%s", res.getString("TenDonVi"), res.getString("CacTuyenXeBuyt"));
//				System.out.printf("%s\t|%s", res.getString("tramid"), res.getString("TENDIEMDUNG"));
				System.out.printf("%s\t|%s\t|%s", res.getInt("id"), res.getInt("STT"), res.getString("TENTRAM"));
				System.out.println();
//				System.out.println("-----------------------");
			}

			res.close();
			stat.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
