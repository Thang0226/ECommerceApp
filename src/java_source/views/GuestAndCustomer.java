package java_source.views;

import java_source.controller.customer_control.CustomerManager;
import java.util.Scanner;

public class GuestAndCustomer {
	public static void main(String[] args) {
		CustomerManager cmanager = CustomerManager.getInstance("data-storage/customers.xlsx");
		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nOptions:
					1. Register new customer
					2. Search product by name
					3. Search products related to a string
					4. Add a product to cart
					5. Purchase an order
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					;
					break;
				case 2:
					break;
				case 3:
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
