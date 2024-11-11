package java_source.model.product;

import java.io.Serial;
import java.io.Serializable;

public abstract class Product implements Cloneable, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private final int id;
	private String name;
	private int price;
	private String brand;
	private String description;

	protected Product(int id, String name, int price, String brand, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	@Override
	public String toString() {
		return "Product{" +
				"id = '" + id + '\'' +
				", name = '" + name + '\'' +
				", price = " + price +
				", brand = '" + brand + '\'' +
				", description = '" + description + '\'' +
				'}';
	}
}
