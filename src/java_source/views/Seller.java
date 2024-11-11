package java_source.views;

import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class Seller {
	public static void main(String[] args) {
		ProductManager pm = ProductManager.getInstance("data-storage/products.dat");

		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nMenu:
					1. Add new product
					2. Change a product
					3. Delete a product
					4. Search a product
					5. Show all products
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					pm.addNewProduct();
					break;
				case 2:
					;
					break;
				case 3:
					pm.deleteProduct();
					break;
				case 4:
					;
					break;
				case 5:
					pm.display();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
