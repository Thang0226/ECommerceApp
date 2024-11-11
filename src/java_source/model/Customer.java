package java_source.model;

public class Customer extends Guest {
	private String name;
	private String email;
	private String password;
	private final Cart cart;

	public Customer(String id, String name, String email, String password) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		cart = new Cart();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getCart() {
		try {
			Cart cartClone = (Cart) cart.clone();
			return cartClone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
