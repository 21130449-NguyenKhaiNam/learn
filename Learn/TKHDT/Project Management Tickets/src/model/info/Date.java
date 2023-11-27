package model.info;

import java.util.Objects;

/**
 * Định nghĩa về ngày
 */
public class Date implements Comparable<Date> {
	// Ngày
	private int day;

	// Tháng
	private int month;

	// Năm
	private int year;

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public String toString() {
		return this.day + " - " + this.month + " - " + this.year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		int comYear = o.year - year;
		if (comYear == 0) {
			int comMonth = o.month - month;
			if (comMonth == 0) {
				int comDay = o.day - day;
				return comDay;
			}
			return comMonth;
		}
		return comYear;
	}

}
