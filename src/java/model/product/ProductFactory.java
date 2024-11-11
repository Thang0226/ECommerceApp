package java.model.product;

import java.util.Scanner;

public class ProductFactory {
	private static ProductFactory factory;

	private ProductFactory() {
	}

	public static ProductFactory getInstance() {
		if (factory == null) {
			factory = new ProductFactory();
		}
		return factory;
	}

	public Product getProduct(ProductType type) {
		return switch (type) {
			case LAPTOP -> inputNewLaptop();
			case TABLET -> inputNewTablet();
			case MOBILE -> inputNewMobile();
			default -> null;
		};
	}

	private Product inputNewLaptop() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter properties of new laptop product:");
		System.out.print("Product ID: ");
		String id = input.nextLine();
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		double price = Double.parseDouble(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.print("CPU: ");
		String cpu = input.nextLine();
		System.out.print("GPU: ");
		String gpu = input.nextLine();
		System.out.println("RAM size (GB): ");
		int ramSize = Integer.parseInt(input.nextLine());
		System.out.println("Product description: ");
		String description = input.nextLine();

		return new Laptop(id, name, price, brand, description, cpu, gpu, ramSize);
	}

	private Product inputNewTablet() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter properties of new tablet product:");
		System.out.print("Product ID: ");
		String id = input.nextLine();
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		double price = Double.parseDouble(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.println("Product description: ");
		String description = input.nextLine();

		return new Tablet(id, name, price, brand, description);
	}

	private Product inputNewMobile() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter properties of new laptop product:");
		System.out.print("Product ID: ");
		String id = input.nextLine();
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Price: ");
		double price = Double.parseDouble(input.nextLine());
		System.out.print("Brand: ");
		String brand = input.nextLine();
		System.out.print("Size: ");
		double size = Double.parseDouble(input.nextLine());
		System.out.print("Weight: ");
		double weight = Double.parseDouble(input.nextLine());
		System.out.println("Camera resolution (MP): ");
		int cameraRes = Integer.parseInt(input.nextLine());
		System.out.println("Product description: ");
		String description = input.nextLine();

		return new MobilePhone(id, name, price, brand, description, size, weight, cameraRes);
	}
}
