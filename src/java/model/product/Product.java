package java.model.product;

public abstract class Product implements Cloneable {
	private String id;
	private String name;
	private double price;
	private String brand;
	private String description;

	public Product(String id, String name, double price, String brand, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public abstract Product clone();
}
