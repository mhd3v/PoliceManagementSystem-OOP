package Model;

import java.io.Serializable;

public class Date implements Serializable {

	private int day;
	private int month;
	private int year;

	Date() {

		day = 0;
		month = 0;
		year = 0;
	}

	public Date(int d, int m, int y)  {

			day = d;
			month = m;
			year = y;
		}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	}

