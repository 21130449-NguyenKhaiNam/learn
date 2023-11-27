package model.management.general;

import java.awt.Image;
import java.util.List;

import model.info.Address;
import model.info.Date;
import model.info.EnumPosition;
import model.management.staff.Work;

/**
 * Định nghĩa các phương thức mà một nhân viên phải có - ở đây là cả quản lý và
 * nhân viên thông thường
 */
public class AEmployee {
	// hình ảnh
	private Image img;

	// mã nhân viên
	private String id;

	// họ tên
	private String name;

	// Quản lý hay nhân viên
	private EnumPosition position;

	// Lương
	private double salary;

	// ngày sinh
	private Date dob;

	// địa chỉ
	private Address address;

	// email
	private String email;

	// số điện thoại
	private String phone;

	// Thời gian truy cập, với nhân viên là thời gian làm
	private List<Work> works;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the img
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the position
	 */
	public EnumPosition getPosition() {
		return position;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the works
	 */
	public List<Work> getWorks() {
		return works;
	}

	public AEmployee(Image img, String id, String name, EnumPosition position, double salary, Date dob, Address address,
			String email, String phone, List<Work> works) {
		this.img = img;
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.works = works;
	}

	public boolean hasId(String oId) {
		// TODO Auto-generated method stub
		return this.id.equals(oId);
	}

	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return this.id.equals("admin");
	}

}
