package model.info;

/**
 * Định nghĩa về 1 địa chỉ nhà cơ bản phải có
 */
public class Address {
	// Số nhà
	private String number;

	// Tên đường
	private String street;

	// Thành phố
	private String city;

	public Address(String number, String street, String city) {
		this.number = number;
		this.street = street;
		this.city = city;
	}

}
