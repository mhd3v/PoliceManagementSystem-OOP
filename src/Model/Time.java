package Model;

import java.io.Serializable;

public class Time implements Serializable {

	private int hours;
	private int minutes;

	Time(){
		hours=0;
		minutes=0;
	}
	
	public Time(int h,int m) {
		
		hours=h;
		minutes=m;
		
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
}
