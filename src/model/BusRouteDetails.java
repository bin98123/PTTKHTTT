package model;

public class BusRouteDetails {
	private int routeID;
	private String unitID;
	private String routeName;
//	private Clock timeStart;
//	private Clock timeEnd;
	private String timeStart;
	private String timeEnd;
//	private Minute timeBreak;
	private double timeBreak;
	private String startLocation;
	private String endLocation;
	private String kindRoute;

	public BusRouteDetails(int routeID, String unitID, String routeName, String timeStart, String timeEnd,
			double timeBreak, String startLocation, String endLocation, String kindRoute) {
		super();
		this.routeID = routeID;
		this.unitID = unitID;
		this.routeName = routeName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeBreak = timeBreak;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.kindRoute = kindRoute;
	}

	public BusRouteDetails() {

	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public double getTimeBreak() {
		return timeBreak;
	}

	public void setTimeBreak(double timeBreak) {
		this.timeBreak = timeBreak;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public String getKindRoute() {
		return kindRoute;
	}

	public void setKindRoute(String kindRoute) {
		this.kindRoute = kindRoute;
	}

	@Override
	public String toString() {
		return "BusRouteDetails [routeID=" + routeID + ", unitID=" + unitID + ", routeName=" + routeName
				+ ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", timeBreak=" + timeBreak + ", startLocation="
				+ startLocation + ", endLocation=" + endLocation + ", kindRoute=" + kindRoute + "]";
	}

}
