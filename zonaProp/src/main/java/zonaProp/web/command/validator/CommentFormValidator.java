package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.web.command.CommentForm;


@Component
public class CommentFormValidator implements Validator {

	private FieldValidator<String> nameValdator = new LengthValidator("name", 3, 20);
	private FieldValidator<String> phoneValdator = new LengthValidator("phone", 3, 20);
	private FieldValidator<String> emailValdator = new LengthValidator("email", 3, 20);
	
	
	public boolean supports(Class<?> clazz) {
		return CommentForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		CommentForm form = (CommentForm) target;
		
		nameValdator.appendError(errors, form.getName());
		phoneValdator.appendError(errors, form.getPhone());
		emailValdator.appendError(errors, form.getEmail());
	}
}
