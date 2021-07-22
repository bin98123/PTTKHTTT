package model;

import java.util.Date;

public class DriverDetails {
	private String driverID;
	private String fullName;
	private Date birthday;
	private boolean male;
	private String address;
	private String country;
	private Date dayBegin;
	private int salary;
	private String driverLicense;
	private String BusID;

	public DriverDetails() {

	}

	public DriverDetails(String driverID, String fullName, Date birthday, boolean male, String address, String country,
			Date dayBegin, int salary, String driverLicense, String busID) {
		super();
		this.driverID = driverID;
		this.fullName = fullName;
		this.birthday = birthday;
		this.male = male;
		this.address = address;
		this.country = country;
		this.dayBegin = dayBegin;
		this.salary = salary;
		this.driverLicense = driverLicense;
		BusID = busID;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean getMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDayBegin() {
		return dayBegin;
	}

	public void setDayBegin(Date dayBegin) {
		this.dayBegin = dayBegin;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getBusID() {
		return BusID;
	}

	public void setBusID(String busID) {
		BusID = busID;
	}

	@Override
	public String toString() {
		return "DriverDetails [driverID=" + driverID + ", fullName=" + fullName + ", birthday=" + birthday + ", male="
				+ male + ", address=" + address + ", country=" + country + ", dayBegin=" + dayBegin + ", salary="
				+ salary + ", driverLicense=" + driverLicense + ", BusID=" + BusID + "]";
	}

}
