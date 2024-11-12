package java_source.controller.customer_control.add;

public class ValidateContext {
	private ValidateString validator;

	public ValidateContext() {
		this.validator = new NameValidate();
	}

	public ValidateContext(ValidateString validator) {
		this.validator = validator;
	}

	public void setValidateType(ValidateString validator) {
		this.validator = validator;
	}

	public boolean validate(String value) {
		return validator.validate(value);
	}
}
