package java_source.model;

import java.util.LinkedList;
import java.util.List;

public class Cart implements Cloneable {
	private final List<OrderItem> items;

	public Cart() {
		this.items = new LinkedList<>();
	}

	public void addOrderItem(OrderItem item) {
		this.items.add(item);
	}

	public void removeOrderItem(OrderItem item) {
		this.items.remove(item);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
