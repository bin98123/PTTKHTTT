package date5_4_2021;

import java.util.List;

public class DonViDamNhan {
	String name;
	List<String> listtuyenxebus;

	public DonViDamNhan(String name, List<String> listtuyenxebus) {
		super();
		this.name = name;
		this.listtuyenxebus = listtuyenxebus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getListtuyenxebus() {
		return listtuyenxebus;
	}

	public void setListtuyenxebus(List<String> listtuyenxebus) {
		this.listtuyenxebus = listtuyenxebus;
	}

}
