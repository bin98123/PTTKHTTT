package dao;

public class loginDAO {
	private int userID;
	private String userName, userFullName, userPassword;

	public loginDAO(int userID, String userName, String userFullName, String userPassword) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userFullName = userFullName;
		this.userPassword = userPassword;
	}

	public loginDAO() {

	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
