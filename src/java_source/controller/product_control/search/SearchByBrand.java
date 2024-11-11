package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.List;
import java.util.Scanner;

public class SearchByBrand implements SearchStrategy {
	@Override
	public void search(List<Product> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter brand name: ");
		String brand = scanner.nextLine();

		System.out.println("Products of the brand:");
		for (Product product : list) {
			if (product.getBrand().equalsIgnoreCase(brand)) {
				System.out.println(product);
			}
		}
	}
}
