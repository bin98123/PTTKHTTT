package model;

public class BusUnitManagerDetails {
	private String unitID;
	private String unitName;
	private String phoneNumber;
	private String email;

	public BusUnitManagerDetails(String unitID, String unitName, String phoneNumber, String email) {
		super();
		this.unitID = unitID;
		this.unitName = unitName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
