package java.view;

import java.util.*;

public class Seller {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("""
				\nMenu:
					1. Add new product
					2. Change a product
					3. Delete a product
					4. Search a product
					4. Show all products
					0. Exit
				Enter your choice:""");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					;
					break;
				case 2:
					;
					break;
				case 3:
					;
					break;
				case 4:
					;
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Not a choice!");
			}
		}
	}
}
