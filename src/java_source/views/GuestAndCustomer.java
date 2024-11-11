package java_source.views;

import java_source.controller.customer_control.CustomerManager;
import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class GuestAndCustomer {
	public static void main(String[] args) {
		CustomerManager cmanager = CustomerManager.getInstance("data-storage/customers.xlsx");
		ProductManager pmanager = ProductManager.getInstance("data-storage/products.dat");
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
//					cmanager.addNewCustomer();
					break;
				case 2:
					pmanager.searchProduct();
					break;
				case 3:
					pmanager.sortByPrice();
					pmanager.display();
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
