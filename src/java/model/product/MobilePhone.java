package java.model.product;

public class MobilePhone extends Product {
	private double size;
	private double weight;
	private int cameraRes;

	public MobilePhone(String id, String name, double price, String brand, String description,
	                   double size, double weight, int cameraRes) {
		super(id, name, price, brand, description);
		this.size = size;
		this.weight = weight;
		this.cameraRes = cameraRes;
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

	public int getCameraRes() {
		return cameraRes;
	}

	public void setCameraRes(int cameraRes) {
		this.cameraRes = cameraRes;
	}

	@Override
	public String toString() {
		return super.toString() +
				"MobilePhone{" +
				", size = " + size +
				", weight = " + weight +
				", camera resolution = '" + cameraRes + '\'' +
				'}';
	}

	@Override
	public MobilePhone clone() {
		return new MobilePhone(getId(), getName(), getPrice(), getBrand(), getDescription(),
				getSize(), getWeight(), getCameraRes());
	}
}
