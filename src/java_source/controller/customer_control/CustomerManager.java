package java_source.controller.customer_control;

import java_source.controller.abstracts.Manager;
import java_source.model.Customer;
import java_source.model.product.Product;

import java.util.Scanner;

public class CustomerManager extends Manager<Customer> {
	private static CustomerManager customerManager;

	private CustomerManager(String filePath) {
		super(filePath);
	}
	// Singleton
	public static CustomerManager getInstance(String filePath) {
		if (customerManager == null) {
			synchronized (CustomerManager.class) {
				if (customerManager == null) {
					customerManager = new CustomerManager(filePath);
				}
			}
		}
		return customerManager;
	}

	@Override
	public void loadList() {
		super.loadList();
	}

	@Override
	public void saveList() {
		super.saveList();
	}

	public boolean addNewCustomer() {
		return false;
	}

	private int inputID() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter product ID: ");
		return scanner.nextInt();
	}

	public boolean deleteCustomer() {
		int id = inputID();
		for (Customer customer : list) {
			if (customer.getId() == id) {
				remove(customer);
				return true;
			}
		}
		return false;
	}
}
