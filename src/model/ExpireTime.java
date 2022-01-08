package model;

import java.sql.Date;
import java.sql.Time;

public class ExpireTime {
	private String userName;
	private java.sql.Time sqlTime;
	private java.sql.Date sqlDate;

	public ExpireTime(String userName, Time sqlTime, Date sqlDate) {
		super();
		this.userName = userName;
		this.sqlTime = sqlTime;
		this.sqlDate = sqlDate;
	}

	@Override
	public String toString() {
		return "ExpireTime [userName=" + userName + ", sqlTime=" + sqlTime + ", sqlDate=" + sqlDate + "]";
	}

}
