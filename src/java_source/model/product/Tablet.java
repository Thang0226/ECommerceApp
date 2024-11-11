package java_source.model.product;

import java.io.Serial;

public class Tablet extends Product {
	@Serial
	private static final long serialVersionUID = 4L;

	public Tablet(int id, String name, int price, String brand, String description) {
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
