package java_source.model.product;

public class Tablet extends Product {
	public Tablet(String id, String name, double price, String brand, String description) {
		super(id, name, price, brand, description);
	}

	@Override
	public Product clone() {
		return new Tablet(getId(), getName(), getPrice(), getBrand(), getDescription());
	}

	@Override
	public String toString() {
		return super.toString() + "-Tablet";
	}
}
