package java_source.controller.customer_control.add;

import java_source.model.Customer;
import java_source.model.product.MobilePhone;

import java.util.Scanner;

public class AddCustomer {
	public Customer inputNewCustomer(int id) {
		Scanner input = new Scanner(System.in);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();
		System.out.print("Password: ");
		String password = input.nextLine();

		return new Customer(id, name, email, password);
	}

	public boolean validateCustomerInfor(Customer customer) {
		boolean passedName = validateName(customer.getName());
		if (!passedName) {

		}
	}
}
