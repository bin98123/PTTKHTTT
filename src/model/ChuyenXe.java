package model;

import java.util.ArrayList;

public class ChuyenXe {
	private int id;
	private ArrayList<String> listTram = new ArrayList<>();

//them

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
		for (int i = 0; i < getListTram().size() - 1; i++) {

			tram = tram + getListTram().get(i) + " - ";
		}
		tram += getListTram().get(getListTram().size() - 1);
		return tram;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "*Chuyến " + id + ": \n" + printList() + "\n";
	}

}
