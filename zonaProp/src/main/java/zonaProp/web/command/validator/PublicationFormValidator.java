package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.web.command.CommentForm;


@Component
public class PublicationFormValidator implements Validator {

	private FieldValidator<String> directionValdator = new LengthValidator("direction", 1, 30);
	private FieldValidator<String> cityValdator = new LengthValidator("city", 1, 30);
	private FieldValidator<String> emailValdator = new LengthValidator("email", 1, 30);
	
	
	public boolean supports(Class<?> clazz) {
		return CommentForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		CommentForm form = (CommentForm) target;
		
		directionValdator.appendError(errors, form.getName());
		cityValdator.appendError(errors, form.getPhone());
		emailValdator.appendError(errors, form.getEmail());
	}
}
