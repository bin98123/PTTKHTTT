package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChuyenXe {
	private int id;
	private ArrayList<String> listTram = new ArrayList<>();

//thêm
	
	
	public ChuyenXe(int id, ArrayList<String> listTram) {
		super();
		this.id = id;
		this.listTram = listTram;
	}

	public int getId() {
		return id;
	}

	public ArrayList<String> getListTram() {
		return listTram;
	}

	public String printList() {
		String tram = "";
		for (String s : getListTram()) {
			tram = tram + s + "\n";
		}
		return tram;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Chuyến " + id + ": \n" + printList() + "\n";
	}

	
	
	
//	public static void main(String[] args) {
//		ArrayList<String> tram = new ArrayList<>();
//		tram.add("An Phú Đông");
//		tram.add("Aone");
//		tram.add("Ba Son");
//		tram.add("Bãi đậu xe kho hàng");
//		ChuyenXe c = new ChuyenXe(19, tram);
//		System.out.println(c.toString());
//		
		
//	System.out.println(c.printList());
//	}
}
