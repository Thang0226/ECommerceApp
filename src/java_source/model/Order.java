package java_source.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order implements Discount{
	private final int id;
	private String address;
	private final LocalDateTime time;
	private final Customer customer;
	private final List<OrderItem> items;
	private final double totalAmount;

	public Order(int id, String address, Customer customer, List<OrderItem> items) {
		this.id = id;
		this.address = address;
		this.time = LocalDateTime.now();
		this.customer = customer;
		this.items = items;
		this.totalAmount = calculateTotalAmount(items);
	}

	private double calculateTotalAmount(List<OrderItem> items) {
		double totalAmount = 0;
		for (OrderItem item : items) {
			totalAmount += item.getTotalPrice();
		}
		return totalAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public double getRealMoney() {
		if (time.getDayOfMonth() == time.getMonthValue()) {
			return getTotalAmount() * (1 - DISCOUNT_RATE);
		}
		return getTotalAmount();
	}
}
