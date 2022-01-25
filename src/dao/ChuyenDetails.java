package dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ChuyenDetails {
//	private int chuyenID;
//	private String luotDi;
//	private String luotVe;
//	private String tenChuyen;
	private int ID;
	private int STT;
	private String temTram;

	public ChuyenDetails() {

	}

	public ChuyenDetails(int ID, int STT, String temTram) {
		super();
		this.ID = ID;
		this.STT = STT;
		this.temTram = temTram;
	}
//
//	public void setChuyenID(int chuyenID) {
//		this.chuyenID = chuyenID;
//	}
//
//	public void setLuotDi(String luotDi) {
//		this.luotDi = luotDi;
//	}
//
//	public void setLuotVe(String luotVe) {
//		this.luotVe = luotVe;
//	}
//
//	public void setTenChuyen(String tenChuyen) {
//		this.tenChuyen = tenChuyen;
//	}
//
//	public int getChuyenID() {
//		return chuyenID;
//	}
//
//	public String getLuotDi() {
//		return luotDi;
//	}
//
//	public String getLuotVe() {
//		return luotVe;
//	}
//
//	public String getTenChuyen() {
//		return tenChuyen;
//	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSTT() {
		return STT;
	}

	public void setSTT(int sTT) {
		STT = sTT;
	}

	public String getTemTram() {
		return temTram;
	}

	public void setTemTram(String temTram) {
		this.temTram = temTram;
	}

	@Override
	public String toString() {
		
		return "ChuyenDetails [ID=" + ID + ", STT=" + STT + ", temTram=" + temTram + "]";
	}
//	@Override
//	public String toString() {
//		String fullName = "ChuyenDetails [ID=" + ID + ", STT=" + STT + ", temTram=" + temTram + "]";
//		String result = "";
//		try {
//			String result1 = URLDecoder.decode(fullName, "UTF-8");
//			result = result1;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		return "ChuyenDetails [ID=" + ID + ", STT=" + STT + ", temTram=" + temTram + "]";
//		return result;
//	}

}
