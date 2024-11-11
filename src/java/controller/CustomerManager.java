package java.controller;

import java.model.Customer;

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
}
