package java_source.model;

public class Customer extends Guest {
	private String name;
	private String email;
	private String password;

	public Customer(int id, String name, String email, String password) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
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

	@Override
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return this.getName().equals(c.getName()) || this.getEmail().equals(c.getEmail())
				|| this.getPassword().equals(c.getPassword());
	}
}
