package java.controller;

import java.model.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	private List<Product> products;

	public void addProduct(Product product) {
		products.add(product);
	}

	public boolean removeProduct(Product product) {
		return products.remove(product);
	}

	public void displayAllProducts() {
		for (Product product : products) {
			System.out.println(product);
		}
	}

	public Product binarySearchByName(String name) {
		int start = 0;
		int end = products.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int compare = products.get(mid).getName().compareToIgnoreCase(name);
			if (compare == 0) {
				return products.get(mid);
			} else if (compare < 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}

	public void sortByPrice() {
		int n = products.size();
		boolean needNextPass = true;
		for (int i = 0; i < n - 1 && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
					needNextPass = true;
					Product temp = products.get(j);
					products.set(j, products.get(j + 1));
					products.set(j + 1, temp);
				}
			}
		}
	}

	public void sortByName() {
		int n = products.size();
		boolean needNextPass = true;
		for (int i = 0; i < n - 1 && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (products.get(j).getName().compareToIgnoreCase(products.get(j + 1).getName()) > 0)  {
					needNextPass = true;
					Product temp = products.get(j);
					products.set(j, products.get(j + 1));
					products.set(j + 1, temp);
				}
			}
		}
	}
}
