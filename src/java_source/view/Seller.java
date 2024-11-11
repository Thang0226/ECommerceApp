package java_source.view;

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
					1. Search product
					2. Add new product
					3. Change a product
					4. Delete a product
					5. Show all products
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					pm.searchProduct();
					break;
				case 2:
					pm.addNewProduct();
					break;
				case 3:
//					pm.changeProduct();
					break;
				case 4:
					pm.deleteProduct();
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
