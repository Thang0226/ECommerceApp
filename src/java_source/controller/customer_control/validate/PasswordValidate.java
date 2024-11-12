package java_source.controller.customer_control.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidate implements ValidateString {
	@Override
	public boolean validate(String value) {
		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
/*
Valid password has:
	At least 8 characters;
    At least 1 uppercase letter;
    At least 1 lowercase letter;
    At least 1 digit;
    At least 1 special character of {@$!%*?&}.
 */