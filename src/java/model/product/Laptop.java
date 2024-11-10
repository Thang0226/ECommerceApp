package java.model.product;

public class Laptop extends Product {
	private String brand;
	private double size;
	private String cpuType;
	private String gpuType;
	private int ramSize;

	public Laptop(String id, String name, double price, String brand, String description, double size,
	              String cpuType, String gpuType, int ramSize) {
		super(id, name, price, brand, description);
		this.size = size;
		this.cpuType = cpuType;
		this.gpuType = gpuType;
		this.ramSize = ramSize;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getCpuType() {
		return cpuType;
	}

	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}

	public String getGpuType() {
		return gpuType;
	}

	public void setGpuType(String gpuType) {
		this.gpuType = gpuType;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	@Override
	public String toString() {
		return "Laptop{" +
				"brand = '" + brand + '\'' +
				", size = " + size +
				", cpuType = '" + cpuType + '\'' +
				", gpuType = '" + gpuType + '\'' +
				", ramSize = " + ramSize +
				'}';
	}

	@Override
	public Laptop clone() {
		return new Laptop(getId(), getName(), getPrice(), getBrand(), getDescription(), getSize(),
				getCpuType(), getGpuType(), getRamSize());
	}
}
