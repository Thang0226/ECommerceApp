package java_source.view;

import java_source.controller.customer_control.CustomerManager;
import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class AppManager {
	public static void main(String[] args) {
		CustomerManager cmanager = CustomerManager.getInstance("data-storage/customers.xlsx");
		ProductManager pmanager = ProductManager.getInstance("data-storage/products.dat");
		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nOptions:
					1. Display all products
					2. Display all customers
					3. Delete a customer
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					pmanager.display();
					break;
				case 2:
					cmanager.display();
					break;
				case 3:
					cmanager.deleteCustomer();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
