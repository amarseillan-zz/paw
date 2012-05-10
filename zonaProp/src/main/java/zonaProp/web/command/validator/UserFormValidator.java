package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.web.command.CommentForm;
import zonaProp.web.command.UserForm;


@Component
public class UserFormValidator implements Validator {

	private FieldValidator<String> usernameV = new LengthValidator("username", 4, 20);
	private FieldValidator<String> passwordV = new LengthValidator("password", 4, 20);
	private FieldValidator<String> nameV = new LengthValidator("name", 3, 20);
	private FieldValidator<String> lastNameV = new LengthValidator("lastname", 3, 20);
	private FieldValidator<String> emailV = new LengthValidator("email", 3, 20);
	private FieldValidator<String> phoneV = new LengthValidator("phone", 3,20);
	
	
	
	public boolean supports(Class<?> clazz) {
		return UserForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		UserForm form = (UserForm) target;
		if(!form.getPassword().equals(form.getPassword2())){
			errors.reject("passwordsDontMatch", "Las contrase&ntilde;as deben ser iguales.");
		}
		usernameV.appendError(errors, form.getUsername());
		passwordV.appendError(errors, form.getPassword());
		nameV.appendError(errors, form.getName());
		lastNameV.appendError(errors, form.getLastname());
		emailV.appendError(errors, form.getEmail());
		phoneV.appendError(errors, form.getPhone());		
	}
}
