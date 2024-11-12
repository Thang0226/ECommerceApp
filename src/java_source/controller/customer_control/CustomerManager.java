package java_source.controller.customer_control;

import java_source.controller.abstracts.Manager;
import java_source.controller.customer_control.validate.CustomerValidate;
import java_source.model.Customer;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManager extends Manager<Customer> {
	private final String FILE_HEADER = "ID, Name, Email, Password";
	private final String DELIMITER = ", ";
	private final String NEW_LINE_SEPARATOR = "\n";

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
		try (BufferedReader br = new BufferedReader(new FileReader(getFilePath())))
		{
			String line = br.readLine(); // cancel header at first row
			while ((line = br.readLine()) != null) {
				String[] propertyArray = line.split(DELIMITER);
				int id = Integer.parseInt(propertyArray[0]);
				String name = propertyArray[1];
				String email = propertyArray[2];
				String password = propertyArray[3];
				list.add(new Customer(id, name, email, password));
			}
			System.out.println("Customer list loaded.");

		} catch (IOException e) {
			System.out.println("Error reading csv file!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void saveList() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(getFilePath());
			fileWriter.append(FILE_HEADER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Customer customer : list) {
				fileWriter.append(String.valueOf(customer.getId()));
				fileWriter.append(DELIMITER);
				fileWriter.append(customer.getName());
				fileWriter.append(DELIMITER);
				fileWriter.append(customer.getEmail());
				fileWriter.append(DELIMITER);
				fileWriter.append(customer.getPassword());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("Customer list saved.");

		} catch (IOException e) {
			System.out.println("Error in CsvFileWriter!");
			System.out.println(e.getMessage());

		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter!");
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean addNewCustomer() {
		Scanner scanner = new Scanner(System.in);
		int id = inputID();
		if (idExisted(id)) {
			System.out.println("Customer ID already existed. Please use another ID.");
			return false;
		}
		final char NO = 'n';
		boolean passed;
		CustomerValidate validator = new CustomerValidate();
		while (true) {
			Customer newCustomer = inputNewCustomer(id);
			passed = validator.validateCustomerInfor(newCustomer);
			if (passed) {
				if (customerExisted(newCustomer)) {
					System.out.println("Customer information already existed!");
					return false;
				}
				add(newCustomer);
				saveList();
				return true;

			} else {
				System.out.println("Input new customer information again? (Y/N)");
				String again = scanner.nextLine().toLowerCase();
				if (again.charAt(0) == NO) {
					return false;
				}
			}
		}
	}

	private int inputID() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter customer ID: ");
			int id = scanner.nextInt();
			return id;
		} catch (InputMismatchException e) {
			System.out.println("Error: Expect an integer ID number.");
		}
		return -1;
	}

	private boolean idExisted(int id) {
		for (Customer customer : list) {
			if (customer.getId() == id) {
				return true;
			}
		}
		return false;
	}

	private Customer inputNewCustomer(int id) {
		Scanner input = new Scanner(System.in);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();
		System.out.print("Password: ");
		String password = input.nextLine();

		return new Customer(id, name, email, password);
	}

	private boolean customerExisted(Customer c) {
		for (Customer customer : list) {
			if (customer.equals(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteCustomer() {
		int id = inputID();
		for (Customer customer : list) {
			if (customer.getId() == id) {
				remove(customer);
				saveList();
				return true;
			}
		}
		return false;
	}
}
