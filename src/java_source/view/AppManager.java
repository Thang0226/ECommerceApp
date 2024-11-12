package java_source.view;

import java_source.controller.customer_control.CustomerManager;
import java_source.controller.guest_control.GuestManager;
import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class AppManager {
	public static void main(String[] args) {
		CustomerManager customerManager = CustomerManager.getInstance("data-storage/customers.csv");
		ProductManager productManager = ProductManager.getInstance("data-storage/products.dat");
		GuestManager guestManager = GuestManager.getInstance("data-storage/guests.dat");
		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nOptions:
					1. Display all products
					2. Display all customers
					3. Delete a customer
					4. Display all guests
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					productManager.display();
					break;
				case 2:
					customerManager.display();
					break;
				case 3:
					customerManager.deleteCustomer();
					break;
				case 4:
					guestManager.display();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
