package java_source.controller.product_control;

import java_source.controller.abstracts.Manager;
import java_source.controller.product_control.search.*;

import java_source.controller.product_control.sort.SortByID;
import java_source.controller.product_control.sort.SortByPriceAsc;
import java_source.controller.product_control.sort.SortByPriceDesc;
import java_source.controller.product_control.sort.SortContext;
import java_source.model.product.Product;
import java_source.model.product.ProductFactory;
import java_source.model.product.ProductType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductManager extends Manager<Product> {
	private static ProductManager productManager;
	private SortContext sortMethod;
	private SearchContext searcher;

	private ProductManager(String filePath) {
		super(filePath);
		sortMethod = new SortContext();
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
		int id = inputID();
		ProductType productType = inputProductType();
		ProductFactory factory = ProductFactory.getInstance();
		Product newProduct = factory.getProduct(productType, id);
		if (newProduct != null) {
			add(newProduct);
			sortByID();
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

	private ProductType inputProductType() {
		System.out.print("Enter product type (Laptop/Tablet/Phone): ");
		String type = (new Scanner(System.in)).nextLine();
		type = type.toUpperCase();
		return ProductType.valueOf(type);
	}

	public void changeProduct() {
		int id = inputID();
	}

	public boolean deleteProduct() {
		int id = inputID();
		final String YES = "YES";
//		final String NO = "NO";

		for (Product product : list) {
			if (product.getId() == id) {

				System.out.println("Are you sure you want to delete this product? (Yes/No)");
				System.out.println(product);
				String confirm = (new Scanner(System.in)).nextLine();
				confirm = confirm.toUpperCase();

				if (confirm.equals(YES)) {
					remove(product);
					sortByID();
					saveList();
					return true;
				}
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
		// Strategy pattern
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

	public void sortByID() {
		sortMethod.setSortMethod(new SortByID());
		sortMethod.sort(list);
	}
	// Strategy pattern
	public void sortByPriceAsc() {
		sortMethod.setSortMethod(new SortByPriceAsc());
		sortMethod.sort(list);
	}

	public void sortByPriceDesc() {
		sortMethod.setSortMethod(new SortByPriceDesc());
		sortMethod.sort(list);
	}
}
