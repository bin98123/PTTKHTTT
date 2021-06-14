package model;

import java.util.Date;

public class AccountDetails {
	private String accountID;
	private String accountName;
	private String password;
	private String fullName;
	private Date birthday;
	private String email;
	private String phoneNumber;

	public AccountDetails(String accountID, String accountName, String password, String fullName, Date birthday,
			String email, String phoneNumber) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.password = password;
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
