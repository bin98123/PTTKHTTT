package model;

public class Path {
	private int start, des;

	public Path(int start, int des) {
		super();
		this.start = start;
		this.des = des;
	}

	@Override
	public String toString() {
		return "Path [start=" + start + ", des=" + des + "]";
	}

	public int getStart() {
		return start;
	}

	public int getDes() {
		return des;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setDes(int des) {
		this.des = des;
	}

}
