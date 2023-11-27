package task3;

import java.util.HashMap;

public class OrderItem {
	private Product item;
	private int amount;

	/**
	 * @param item
	 * @param amount
	 */
	public OrderItem(Product item, int amount) {
		super();
		this.item = item;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderItem [item=" + item + ", amount=" + amount + "]";
	}

	/**
	 * @return the item
	 */
	public Product getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Product item) {
		this.item = item;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int maxPriceProduct(OrderItem that) {
		return item.compare(that.item);
	}

	public void productTypesStatistics(HashMap<String, Integer> map) {
		item.productTypesStatistics(map, amount);
	}
	
	public int getPrice() {
		return item.getPrice();
	}

}
