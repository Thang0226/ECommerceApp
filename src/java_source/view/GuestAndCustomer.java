package java_source.view;

import java_source.controller.customer_control.CustomerManager;
import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class GuestAndCustomer {
	public static void main(String[] args) {
		CustomerManager customerManager = CustomerManager.getInstance("data-storage/customers.csv");
		ProductManager productManager = ProductManager.getInstance("data-storage/products.dat");

		// Check guest or customer method

		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nOptions:
					1. Register new customer
					2. Search product
					3. Sort products in price order
					4. Add a product to cart
					5. Purchase an order
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					customerManager.addNewCustomer();
					break;
				case 2:
					productManager.searchProduct();
					break;
				case 3:
					productManager.sortByPrice();
					productManager.display();
					break;
				case 4:
					break;
				case 5:
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
