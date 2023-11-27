package task3;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Order {
	private String id;
	private String customer;
	private String employee;
	private Date date;
	private List<OrderItem> items;

	/**
	 * @param id
	 * @param customer
	 * @param employee
	 * @param date
	 * @param items
	 */
	public Order(String id, String customer, String employee, Date date, List<OrderItem> items) {
		super();
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", employee=" + employee + ", date=" + date + ", items="
				+ items + "]";
	}

	public Product maxPrice() {
		return items.stream().max(OrderItem::maxPriceProduct).get().getItem();
	}

	public int maxPriceProduct(Order that) {
		return this.maxPrice().compare(that.maxPrice());
	}

	public void productTypesStatistics(HashMap<String, Integer> map) {
		items.stream().forEach(item -> item.productTypesStatistics(map));
	}

	public int compareSumPrice(Order that) {
		return that.sumPrice() - sumPrice();
	}

	public int sumPrice() {
		return items.stream().map(OrderItem::getPrice).reduce(0, Integer::sum);
	}

}
