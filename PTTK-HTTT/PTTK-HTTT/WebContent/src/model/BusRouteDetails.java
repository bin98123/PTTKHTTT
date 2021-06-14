package model;

public class BusRouteDetails {
	private int routeID;
	private String unitID;
	private String routeName;
	private Clock timeStart;
	private Clock timeEnd;
	private Minute timeBreak;
	private String startLocation;
	private String endLocation;
	private boolean kindRoute;

	public BusRouteDetails(int routeID, String unitID, String routeName, Clock timeStart, Clock timeEnd,
			Minute timeBreak, String startLocation, String endLocation, boolean kindRoute) {
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

	public Clock getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Clock timeStart) {
		this.timeStart = timeStart;
	}

	public Clock getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Clock timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Minute getTimeBreak() {
		return timeBreak;
	}

	public void setTimeBreak(Minute timeBreak) {
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

	public boolean getKindRoute() {
		return kindRoute;
	}

	public void setKindRoute(boolean kindRoute) {
		this.kindRoute = kindRoute;
	}
}
