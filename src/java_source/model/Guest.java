package java_source.model;

public class Guest {
	private String id;
	private Cart cart;

	public Guest(String id) {
		this.id = id;
		this.cart = new Cart();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
