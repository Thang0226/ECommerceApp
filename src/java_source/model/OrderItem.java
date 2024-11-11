package java_source.model;

import java_source.model.product.Product;

public class OrderItem {
	private final Product product;
	private int quantity;
	private double totalPrice;

	public OrderItem(Product product, int quantity) {
		this.product = product.clone();
		this.quantity = quantity;
		this.totalPrice = calculateTotalPrice(product, quantity);
	}

	private double calculateTotalPrice(Product product, int quantity) {
		return product.getPrice() * quantity;
	}

	public Product getProduct() {
		return product.clone();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		totalPrice = calculateTotalPrice(product, quantity);
	}

	public double getTotalPrice() {
		return totalPrice;
	}
}
