package task3;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class OrderManger {
	private List<Order> orders;

	/**
	 * @param orders
	 */
	public OrderManger(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderManger [orders=" + orders + "]";
	}

	public Product maxProduct() {
		return orders.stream().max(Order::maxPriceProduct).get().maxPrice();
	}

	public HashMap<String, Integer> productTypesStatistics() {
		HashMap<String, Integer> map = new HashMap<>();
		orders.stream().forEach(orders -> orders.productTypesStatistics(map));
		return map;
	}
	public TreeSet<Order> ordersByCost() {
		TreeSet<Order> treeSet = new TreeSet<>(Order::compareSumPrice);
		treeSet.addAll(orders);
		return treeSet;
	}
	

}
