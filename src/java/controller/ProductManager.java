package java.controller;

import java.model.product.Product;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductManager extends Manager<Product> {
	private static ProductManager productManager;

	private ProductManager(String filePath) {
		super(filePath);
	}
	// Singleton
	public static ProductManager getInstance(String filePath) {
		if (productManager == null) {
			synchronized (ProductManager.class) {
				if (productManager == null) {
					productManager = new ProductManager(filePath);
				}
			}
		}
		return productManager;
	}

	public Product binarySearchByName(String name) {
		int start = 0;
		int end = list.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int compare = list.get(mid).getName().compareToIgnoreCase(name);
			if (compare == 0) {
				return list.get(mid);
			} else if (compare < 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}

	public void searchByString(String str) {
		Pattern pattern = Pattern.compile(str);
		System.out.println("Products related to '" + str + "':");
		for (Product product : list) {
			Matcher nameMatcher = pattern.matcher(product.getName());
			Matcher brandMatcher = pattern.matcher(product.getBrand());
			Matcher descriptionMatcher = pattern.matcher(product.getDescription());
			if (nameMatcher.find() || brandMatcher.find() || descriptionMatcher.find()) {
				System.out.println(product);
			}
		}
	}

	public void sortByPrice() {
		int n = list.size();
		boolean needNextPass = true;
		for (int i = 0; i < n - 1 && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
					needNextPass = true;
					Product temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}

	public void sortByName() {
		int n = list.size();
		boolean needNextPass = true;
		for (int i = 0; i < n - 1 && needNextPass; i++) {
			needNextPass = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (list.get(j).getName().compareToIgnoreCase(list.get(j + 1).getName()) > 0)  {
					needNextPass = true;
					Product temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
}
