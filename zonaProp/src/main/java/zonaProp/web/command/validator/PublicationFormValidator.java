package zonaProp.web.command.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.DoubleValidator;
import zonaProp.validators.FieldValidator;
import zonaProp.validators.IntegerValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.validators.NotNullValidator;
import zonaProp.web.command.PublicationForm;


@Component
public class PublicationFormValidator implements Validator {

	private FieldValidator<String> directionValdator = new LengthValidator("address", 1, 30);
	private FieldValidator<String> cityValdator = new LengthValidator("city", 1, 30);
	
	private FieldValidator<String> precioValdator = new DoubleValidator("price");
	private FieldValidator<String> coveredValdator = new DoubleValidator("covered");
	private FieldValidator<String> uncoveredValdator = new DoubleValidator("uncovered");
	
	private FieldValidator<String> ageValdator = new IntegerValidator("age");
	
	private FieldValidator<Object> operationTypeValidator = new NotNullValidator("operationType");
	private FieldValidator<Object> propertyTypeValidator = new NotNullValidator("propertyType");
	
	
	public boolean supports(Class<?> clazz) {
		return PublicationForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		PublicationForm form = (PublicationForm) target;
		
		directionValdator.appendError(errors, form.getAddress());
		cityValdator.appendError(errors, form.getCity());
		precioValdator.appendError(errors, form.getPrice());
		coveredValdator.appendError(errors, form.getCovered());
		uncoveredValdator.appendError(errors, form.getUncovered());
		ageValdator.appendError(errors, form.getAge());
		operationTypeValidator.appendError(errors, form.getOperationType());
		propertyTypeValidator.appendError(errors, form.getPropertyType());
	}
}
