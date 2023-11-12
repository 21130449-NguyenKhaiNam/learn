package model.management.staff;

import model.info.Date;
import model.info.EnumPositionStaff;
import model.info.EnumStatusType;

/**
 * Định nghĩa về quá trình làm việc của nhân viên
 */
public class Work {
	// Ngày đi làm
	private Date date;

	// Khi vực đi làm
	private EnumPositionStaff location;

	// Trạng thái công việc
	private EnumStatusType status;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the location
	 */
	public EnumPositionStaff getLocation() {
		return location;
	}

	/**
	 * @return the status
	 */
	public EnumStatusType getStatus() {
		return status;
	}

	public Work(Date date, EnumPositionStaff location, EnumStatusType status) {
		this.date = date;
		this.location = location;
		this.status = status;
	}

}
