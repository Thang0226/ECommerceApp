package java_source.model.product;

import java.util.Scanner;

public class ProductFactory {
	private static ProductFactory factory;

	private ProductFactory() {
	}
	// Singleton
	public static ProductFactory getInstance() {
		if (factory == null) {
			factory = new ProductFactory();
		}
		return factory;
	}

	// Factory method
	public Product getProduct(ProductType type, int id) {
		return switch (type) {
			case LAPTOP -> inputNewLaptop(id);
			case TABLET -> inputNewTablet(id);
			case PHONE -> inputNewPhone(id);
			default -> null;
		};
	}

	private Product inputNewLaptop(int id) {
		Scanner input = new Scanner(System.in);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		int price = Integer.parseInt(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.print("CPU: ");
		String cpu = input.nextLine();
		System.out.print("GPU: ");
		String gpu = input.nextLine();
		System.out.print("RAM size (GB): ");
		int ramSize = Integer.parseInt(input.nextLine());
		System.out.print("Product description: ");
		String description = input.nextLine();

		return new Laptop(id, name, price, brand, description, cpu, gpu, ramSize);
	}

	private Product inputNewTablet(int id) {
		Scanner input = new Scanner(System.in);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		int price = Integer.parseInt(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.print("Product description: ");
		String description = input.nextLine();

		return new Tablet(id, name, price, brand, description);
	}

	private Product inputNewPhone(int id) {
		Scanner input = new Scanner(System.in);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		int price = Integer.parseInt(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.print("Size: ");
		double size = Double.parseDouble(input.nextLine());
		System.out.print("Weight: ");
		double weight = Double.parseDouble(input.nextLine());
		System.out.print("Camera resolution (MP): ");
		int cameraRes = Integer.parseInt(input.nextLine());
		System.out.print("Product description: ");
		String description = input.nextLine();

		return new MobilePhone(id, name, price, brand, description, size, weight, cameraRes);
	}
}
