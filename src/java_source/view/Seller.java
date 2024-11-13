package java_source.view;

import java_source.controller.product_control.ProductManager;

import java.util.Scanner;

public class Seller {
	public static void main(String[] args) {
		ProductManager productManager = ProductManager.getInstance("data-storage/products.dat");

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
					6. Sort products in price ascending order
					7. Sort products in price descending order
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					productManager.searchProduct();
					break;
				case 2:
					productManager.addNewProduct();
					break;
				case 3:
					productManager.changeProduct();
					break;
				case 4:
					productManager.deleteProduct();
					break;
				case 5:
					productManager.sortByID();
					productManager.display();
					break;
				case 6:
					productManager.sortByPriceAsc();
					productManager.display();
					break;
				case 7:
					productManager.sortByPriceDesc();
					productManager.display();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
