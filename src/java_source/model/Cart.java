package java_source.model;

import java.util.LinkedList;
import java.util.List;

public class Cart {
	private Guest guest;
	private List<OrderItem> items;

	public Cart(Guest guest) {
		this.guest = guest;
		this.items = new LinkedList<>();
	}

	public void addOrderItem(OrderItem item) {
		this.items.add(item);
	}

	public void removeOrderItem(OrderItem item) {
		this.items.remove(item);
	}
}
