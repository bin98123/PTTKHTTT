package date5_4_2021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDemo {
//	List<Integer> listSTTStart = new ArrayList<>();
//	List<Integer> listSTTGoal = new ArrayList<>();
	List<Double> listBus = new ArrayList<>();

	private Connection getConnect() throws SQLException {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:sqlserver://localhost;databaseName=QLXeBus;user=sa;password=root";
		Connection con = DriverManager.getConnection(dbURL);
		return con;
	}

//	private List<Integer> getSTTStart(String tram) throws SQLException {
//		// TODO Auto-generated method stub
//		Statement sta = getConnect().createStatement();
//		ResultSet re = sta.executeQuery("select id, stt from Chuyen where TenTram = N'" + tram + "' and ID = 19");
//		while (re.next()) {
//			int stt = re.getInt(1);
//			listSTTStart.add(stt);
//		}
//		return listSTTStart;
//	}
	private List<Double> getBus() throws SQLException {
		Statement sta = getConnect().createStatement();
		ResultSet re = sta.executeQuery("select distinct ID from Chuyen");
		double id;
		// danh sách các chuyến xe bus trong csdl:
		while (re.next()) {
			id = re.getDouble(1);
			listBus.add(id);
		}
		return listBus;
	}

//	private void getSTTGoal() {
//		// TODO Auto-generated method stub
//
//	}
//	private List<Integer> getSTTGoal(String tram) throws SQLException {
//		// TODO Auto-generated method stub
//		Statement sta = getConnect().createStatement();
//		ResultSet re;
//		int id;
//		System.out.println(getBus().toString());
//		for(int i : getBus()) {
////			id = getBus().get(
//		re = sta.executeQuery("select STT from Chuyen where TenTram = N'" + tram + "' and ID = " + i);
//		while (re.next()) {
//			int stt = re.getInt(1);
//			listSTTGoal.add(stt);
//		}}
//		return listSTTGoal;
//	}
	private void search() throws SQLException {
		Statement sta = getConnect().createStatement();
		ResultSet re;
		for (int i = 0; i < getBus().size(); i++) {
			System.out.println("bus: " + getBus().get(i));
			System.out.println("----------------------------");
//			System.out.println(getBus().size());
			re = sta.executeQuery(
					"select TenTram from Chuyen where  STT >= (select top(1) STT from Chuyen where TenTram = N'Hồ Bơi' and ID ="
							+ getBus().get(i) + ") and ID = " + getBus().get(i)
							+ " and STT < =(select top(1) STT from Chuyen where TenTram = N'Đại học Quốc tế' and ID = "
							+ getBus().get(i) + ")" + "");
			while (re.next()) {
				System.out.println(re.getString(1));
			}
//			break;
		}
		System.out.println("----------------------------");
	}

	public static void main(String[] args) throws SQLException {
		DatabaseDemo d1 = new DatabaseDemo();
		System.out.println(d1.getBus().toString());
//		System.out.println(d1.getSTTGoal("Tôn Thất Tùng").toString());
//		System.out.println(d1.getSTTStart("Hồ Bơi").toString());
		d1.search();
	}
}
