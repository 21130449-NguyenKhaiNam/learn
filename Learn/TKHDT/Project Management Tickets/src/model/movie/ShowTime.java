package model.movie;

import java.util.Objects;

import model.info.Date;

/**
 * Thông tin về thời gian chiếu của phim
 */
public class ShowTime implements Comparable<ShowTime> {
	private int hour;
	private int minute;
	private int second;
	private Date date;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	public ShowTime(int hour, int minute, int second, Date date) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.date = date;
	}

	@Override
	public String toString() {
		return date + " " + getTime();
	}

	// Chỉ trả về thời gian chiếu
	public String getTime() {
		return hour + " : " + minute + " : " + second;
	}

	@Override
	public int hashCode() {
		return date.getDay() + date.getMonth() + date.getYear() + hour + minute + second;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowTime other = (ShowTime) obj;
		return Objects.equals(date, other.date) && hour == other.hour && minute == other.minute
				&& second == other.second;
	}

	@Override
	public int compareTo(ShowTime o) {
		// TODO Auto-generated method stub
		int comDate = date.compareTo(o.date);
		if (comDate == 0) {
			int comHour = hour - o.hour;
			if (comHour == 0) {
				int comMinute = minute - o.minute;
				if (comMinute == 0) {
					int comSecond = second - o.second;
					return comSecond;
				}
				return comMinute;
			}
			return comHour;
		}
		return comDate;
	}

}
