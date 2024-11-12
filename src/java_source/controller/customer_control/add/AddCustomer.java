package java_source.controller.customer_control.add;

import java_source.model.Customer;

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
		ValidateContext validator = new ValidateContext();

		validator.setValidateType(new NameValidate());
		boolean passedName = validator.validate(customer.getName());
		if (!passedName) {
			System.out.println("""
					Input name is invalid.
					Valid name has:
						3-20 characters;
						letters (upper-case & lower-case) and digits;
						hyphens(-), underscores(_) and spaces.""");
		}
		validator.setValidateType(new EmailValidate());
		boolean passedEmail = validator.validate(customer.getEmail());
		if (!passedEmail) {
			System.out.println("""
					Input email is invalid.
					Valid email has:
						Local part allows alphanumeric characters, dots(.), underscores(_), percent(%), plus(+), and hyphens(-);
						One @ symbol;
						Domain part allows only alphanumeric characters;
						One dot;
						At least 2 letter character following the dot.""");
		}
		validator.setValidateType(new PasswordValidate());
		boolean passedPassword = validator.validate(customer.getPassword());
		if (!passedPassword) {
			System.out.println("""
					Input password is invalid.
					Valid password has:
						At least 8 characters;
					    At least 1 uppercase letter;
					    At least 1 lowercase letter;
					    At least 1 digit;
					    At least 1 special character of {@$!%*?&}.""");
		}

		return passedName && passedEmail && passedPassword;
	}
}
