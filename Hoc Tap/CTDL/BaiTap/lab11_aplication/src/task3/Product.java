package task3;

import java.util.Date;
import java.util.HashMap;

public class Product {
	private String name;
	private String type;
	private int price;
	private Date expiredDate;

	/**
	 * @param name
	 * @param type
	 * @param price
	 * @param expiredDate
	 */
	public Product(String name, String type, int price, Date expiredDate) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.expiredDate = expiredDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the expiredDate
	 */
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	 * @param expiredDate the expiredDate to set
	 */
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", price=" + price + ", expiredDate=" + expiredDate + "]";
	}

	public int compare(Product that) {
		// TODO Auto-generated method stub
		return price - that.price;
	}

	public void productTypesStatistics(HashMap<String, Integer> map, int amount) {
		// TODO Auto-generated method stub
		if (!map.containsKey(type))
			map.put(type, 0);
		map.put(type, map.get(type) + amount);
	}

}
