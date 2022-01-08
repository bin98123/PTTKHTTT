package model;

public class BusStopDetails {
	private int routeID;
	private int serial;
	private String nameBusStop;

	public BusStopDetails(int routeID, int serial, String nameBusStop) {
		super();
		this.routeID = routeID;
		this.serial = serial;
		this.nameBusStop = nameBusStop;
	}

	public BusStopDetails() {

	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getNameBusStop() {
		return nameBusStop;
	}

	public void setNameBusStop(String nameBusStop) {
		this.nameBusStop = nameBusStop;
	}

	@Override
	public String toString() {
		return "BusStopDetails [routeID=" + routeID + ", serial=" + serial + ", nameBusStop=" + nameBusStop + "]";
	}

}
