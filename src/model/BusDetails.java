package model;

import java.sql.Date;

public class BusDetails {
	private String busID;
	private String licensePlate;
	private String kind;
	private Date manufactureDay;
	private Date lateGuaranteeDay;
	private int routeID;

	@Override
	public String toString() {
		return "BusDetails [busID=" + busID + ", licensePlate=" + licensePlate + ", kind=" + kind + ", manufactureDay="
				+ manufactureDay + ", lateGuaranteeDay=" + lateGuaranteeDay + ", routeID=" + routeID + "]";
	}

	public BusDetails(String busID, String licensePlate, String kind, Date manufactureDay, Date lateGuaranteeDay,
			int routeID) {
		super();
		this.busID = busID;
		this.licensePlate = licensePlate;
		this.kind = kind;
		this.manufactureDay = manufactureDay;
		this.lateGuaranteeDay = lateGuaranteeDay;
		this.routeID = routeID;
	}

	public BusDetails() {

	}

	public String getBusID() {
		return busID;
	}

	public void setBusID(String busID) {
		this.busID = busID;
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
