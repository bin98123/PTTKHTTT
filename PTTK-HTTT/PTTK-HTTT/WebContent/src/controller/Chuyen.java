package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ChuyenDetails;

public class Chuyen {
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Bus;user=sa;password=root";

	public List<ChuyenDetails> getChuyens() {
		List<ChuyenDetails> result = new ArrayList<ChuyenDetails>();
		List<ChuyenDetails> chuyens = new ArrayList<ChuyenDetails>();
		int available = 0;
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Chuyen");
			while (rs.next()) {
				ChuyenDetails chuyen = new ChuyenDetails();
//				available++;
//				System.out.println("Khanh");
				chuyen.setID(rs.getFloat("ID"));
//				System.out.println(rs.getFloat("ID"));
				chuyen.setSTT(rs.getInt("STT"));
//				System.out.println(rs.getInt("STT"));
				chuyen.setTemTram(rs.getNString("TenTram"));
//				System.out.println(rs.getNString("TenTram"));
				chuyens.add(chuyen);
//				for (ChuyenDetails chuyenDetails : chuyens) {
//					chuyen.setChuyenID(rs.getInt("ChuyenID"));
//					chuyen.setLuotDi(rs.getString("LUOTDI"));
//					chuyen.setLuotVe(rs.getString("LUOTVE"));
//					chuyen.setTenChuyen(rs.getString("TENCHUYEN"));
//					chuyen.setID(rs.getFloat("ID"));
//					System.out.println(rs.getFloat("ID"));
//					chuyen.setSTT(rs.getInt("STT"));
//					System.out.println(rs.getInt("STT"));
//					chuyen.setTemTram(rs.getString("TenTram"));
//					System.out.println(rs.getString("TenTram"));
//					chuyens.add(chuyen);
//				}
			}
			result = chuyens;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
//		if (available != 0) {
//			return true;
//		}
		return chuyens;

	}

//	public static void main(String[] args) {
//		System.out.println(new Chuyen().getChuyens());
//	}
//
//	@Override
//	public String toString() {
//		return "Chuyen [connectionUrl=" + connectionUrl + "]";
//	}
//	
}
