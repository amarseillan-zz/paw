package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.LoginUserForm;


@Component
public class LoginUserFormValidator implements Validator {

	private FieldValidator<String> usernameValdator = new LengthValidator("username", 3, 20);
	private FieldValidator<String> passwordValdator = new LengthValidator("password", 3, 20);
	
	
	public boolean supports(Class<?> clazz) {
		return CommentForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		LoginUserForm form = (LoginUserForm) target;
		usernameValdator.appendError(errors, form.getUsername());
		passwordValdator.appendError(errors, form.getPassword());
	}
}
