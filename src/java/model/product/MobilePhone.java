package java.model.product;

public class MobilePhone extends Product {
	private String brand;
	private double size;
	private double weight;
	private String cameraType;

	public MobilePhone(String id, String name, double price, String brand, String description,
	                   double size, double weight, String cameraType) {
		super(id, name, price, brand, description);
		this.brand = brand;
		this.size = size;
		this.weight = weight;
		this.cameraType = cameraType;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCameraType() {
		return cameraType;
	}

	public void setCameraType(String cameraType) {
		this.cameraType = cameraType;
	}

	@Override
	public String toString() {
		return "MobilePhone{" +
				"brand = '" + brand + '\'' +
				", size = " + size +
				", weight = " + weight +
				", cameraType = '" + cameraType + '\'' +
				'}';
	}


	@Override
	public MobilePhone clone() {
		return new MobilePhone(getId(), getName(), getPrice(), getBrand(), getDescription(),
				getSize(), getWeight(), getCameraType());
	}
}
