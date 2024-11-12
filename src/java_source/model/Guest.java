package java_source.model;

public class Guest {
	private int id;
	protected Cart cart;

	public Guest(int id) {
		this.id = id;
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
