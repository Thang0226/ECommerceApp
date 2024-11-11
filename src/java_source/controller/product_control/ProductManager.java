package java_source.controller.product_control;

import java_source.controller.abstracts.Manager;
import java_source.model.product.Product;
import java_source.model.product.ProductFactory;
import java_source.model.product.ProductType;
import java.util.Scanner;
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

	public boolean addNewProduct() {
		ProductType productType = inputProductType();
		String id = inputID();
		if (idExisted(id)) {
			System.out.println("Product ID already existed. Please use another ID.");
			return false;
		}
		ProductFactory factory = ProductFactory.getInstance();
		Product newProduct = factory.getProduct(productType, id);
		if (newProduct != null) {
			add(newProduct);
			return true;
		}
		return false;
	}

	private String inputID() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter product ID: ");
		return scanner.nextLine();
	}

	private boolean idExisted(String id) {
		for (Product product : list) {
			if (product.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private ProductType inputProductType() {
		System.out.print("Enter product type (Laptop/Tablet/Phone): ");
		String type = (new Scanner(System.in)).nextLine();
		type = type.toUpperCase();
		return ProductType.valueOf(type);
	}

	public boolean deleteProduct() {
		String id = inputID();
		for (Product product : list) {
			if (product.getId().equals(id)) {
				remove(product);
				return true;
			}
		}
		return false;
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
