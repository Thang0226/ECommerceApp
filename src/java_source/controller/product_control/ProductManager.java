package java_source.controller.product_control;

import java_source.controller.abstracts.Manager;
import java_source.controller.product_control.search.*;

import java_source.model.product.Product;
import java_source.model.product.ProductFactory;
import java_source.model.product.ProductType;

import java.util.InputMismatchException;
import java.util.Scanner;

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
		int id = inputID();
		if (idExisted(id)) {
			System.out.println("Product ID already existed. Please use another ID.");
			return false;
		}
		ProductFactory factory = ProductFactory.getInstance();
		Product newProduct = factory.getProduct(productType, id);
		if (newProduct != null) {
			add(newProduct);
			saveList();
			return true;
		}
		return false;
	}

	private int inputID() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter product ID: ");
			int id = scanner.nextInt();
			return id;
		} catch (InputMismatchException e) {
			System.out.println("Error: Expect an integer ID number.");
		}
		return -1;
	}

	private boolean idExisted(int id) {
		for (Product product : list) {
			if (product.getId() == id) {
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
		int id = inputID();
		for (Product product : list) {
			if (product.getId() == id) {
				remove(product);
				saveList();
				return true;
			}
		}
		return false;
	}

	public void searchProduct() {
		Scanner input = new Scanner(System.in);
		System.out.println("""
				Search product by:
				1. Brand
				2. Name
				3. Price
				4. ID
				5. Keyword
				Enter your choice:""");
		int choice = input.nextInt();
		SearchContext searcher;
		switch (choice) {
			case 1:
				searcher = new SearchContext(new SearchByBrand());
				break;
			case 2:
				searcher = new SearchContext(new SearchByName());
				break;
			case 3:
				searcher = new SearchContext(new SearchByPrice());
				break;
			case 4:
				searcher = new SearchContext(new SearchByID());
				break;
			case 5:
				searcher = new SearchContext(new SearchByKeyWord());
				break;
			default:
				System.out.println("Not a choice!");
				return;
		}
		searcher.search(list);
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
}
