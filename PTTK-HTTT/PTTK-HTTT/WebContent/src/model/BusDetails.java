package model;

import java.util.Date;

public class BusDetails {
	private String driverID;
	private String licensePlate;
	private String kind;
	private Date manufactureDay;
	private Date lateGuaranteeDay;
	private int routeID;

	public BusDetails(String driverID, String licensePlate, String kind, Date manufactureDay, Date lateGuaranteeDay,
			int routeID) {
		super();
		this.driverID = driverID;
		this.licensePlate = licensePlate;
		this.kind = kind;
		this.manufactureDay = manufactureDay;
		this.lateGuaranteeDay = lateGuaranteeDay;
		this.routeID = routeID;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Date getManufactureDay() {
		return manufactureDay;
	}

	public void setManufactureDay(Date manufactureDay) {
		this.manufactureDay = manufactureDay;
	}

	public Date getLateGuaranteeDay() {
		return lateGuaranteeDay;
	}

	public void setLateGuaranteeDay(Date lateGuaranteeDay) {
		this.lateGuaranteeDay = lateGuaranteeDay;
	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

}
