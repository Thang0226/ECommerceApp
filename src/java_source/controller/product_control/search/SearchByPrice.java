package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SearchByPrice implements SearchStrategy {
	private final int PRICE_RANGE = 100;

	@Override
	public void search(List<Product> list) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter a price: ");
			int price = scanner.nextInt();

			System.out.println("Products have price around " + price + ":");
			for (Product product : list) {
				int difference = Math.abs(price - product.getPrice());
				if (difference <= PRICE_RANGE) {
					System.out.println(product);
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Expect an integer input price.");
		}
	}
}
