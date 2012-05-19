package zonaProp.web.command.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.NotNullValidator;
import zonaProp.validators.PositiveIntValidator;
import zonaProp.web.command.EnvironmentForm;


@Component
public class EnvironmentFormValidator implements Validator {

	private FieldValidator<String> widthValidator = new PositiveIntValidator("width");
	private FieldValidator<String> depthValidator = new PositiveIntValidator("depth");
	private FieldValidator<Object> environmentTypeValidator = new NotNullValidator("env");	
	
	public boolean supports(Class<?> clazz) {
		return EnvironmentForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		EnvironmentForm form = (EnvironmentForm) target;
		
		widthValidator.appendError(errors, form.getWidth());
		depthValidator.appendError(errors, form.getDepth());
		environmentTypeValidator.appendError(errors, form.getEnv());
	}
}
