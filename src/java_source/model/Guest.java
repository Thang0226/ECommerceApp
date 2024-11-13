package java_source.model;

import java_source.model.for_develop.Cart;

public class Guest {
	private static int count = 0;
	private int id;
	protected Cart cart;

	public Guest() {
		this.id = ++count;
		this.cart = new Cart();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		try {
			return (Cart) cart.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
