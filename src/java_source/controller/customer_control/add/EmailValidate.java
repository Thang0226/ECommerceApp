package java_source.controller.customer_control.add;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate implements ValidateString {
	@Override
	public boolean validate(String value) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
/*
Valid email only has:
	Local part allows alphanumeric characters, dots(.), underscores(_), percent(%), plus(+), and hyphens(-);
	One @ symbol;
	Domain part allows only alphanumeric characters;
	One dot;
	At least 2 letter character following the dot.
 */
