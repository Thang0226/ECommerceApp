package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.List;
import java.util.Scanner;

public class SearchByName implements SearchStrategy {
	@Override
	public void search(List<Product> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();

		System.out.println("Products named " + name + ":");
		for (Product product : list) {
			if (product.getName().equalsIgnoreCase(name)) {
				System.out.println(product);
			}
		}
	}
}
