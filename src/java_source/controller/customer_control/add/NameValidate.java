package java_source.controller.customer_control.add;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidate implements ValidateString {
	@Override
	public boolean validate(String value) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9 _-]{3,20}$");
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
/*
Valid name only has:
	3-20 characters;
	letters (upper-case & lower-case) and digits;
	hyphens(-), underscores(_) and spaces.
 */