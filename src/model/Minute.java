package model;

public class Minute {
	private int minute, second;

	public Minute(int minute, int second) {
		super();
		this.minute = minute;
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "Minute [minute=" + minute + ", second=" + second + "]";
	}
}
