package zonaProp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailFormatValidator extends FieldValidator<String> {

	private Pattern pattern;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public MailFormatValidator(String fieldName) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		this.type = "mailFormat";
		this.fieldName = fieldName;
	}

	@Override
	public String getError() {
		return "El campo "+fieldName+" no tiene formato de mail.";
	}

	@Override
	public boolean isCorrect(String value) {
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}
