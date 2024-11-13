package java_source.controller.product_control.search;

import java_source.model.product.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SearchByID implements SearchStrategy {
	@Override
	public void search(List<Product> list) {
		sortByID(list);
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter product ID: ");
			int id = scanner.nextInt();
			// Binary search (not recursive)
			int start = 0;
			int end = list.size() - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				int productID = list.get(mid).getId();
				if (productID == id) {
					System.out.println("Product found:");
					System.out.println(list.get(mid));
					return;
				} else if (id < productID) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			System.out.println("Product ID not found");

		} catch (InputMismatchException e) {
			System.out.println("Error: Expect an integer ID.");
		}
	}

	private void sortByID(List<Product> list) {

	}
}
