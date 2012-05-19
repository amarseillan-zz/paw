package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.validators.NotNullValidator;
import zonaProp.validators.PositiveDoubleValidator;
import zonaProp.validators.PositiveIntValidator;
import zonaProp.web.command.PublicationForm;

@Component
public class PublicationFormValidator implements Validator {

	private FieldValidator<String> directionValdator = new LengthValidator(
			"address", 1, 30);
	private FieldValidator<String> cityValdator = new LengthValidator("city",
			1, 30);

	private FieldValidator<String> precioValdator = new PositiveDoubleValidator(
			"price");
	private FieldValidator<String> coveredValdator = new PositiveDoubleValidator(
			"covered");
	private FieldValidator<String> uncoveredValdator = new PositiveDoubleValidator(
			"uncovered");

	private FieldValidator<String> ageValdator = new PositiveIntValidator("age");

	private FieldValidator<Object> operationTypeValidator = new NotNullValidator(
			"operationType");
	private FieldValidator<Object> propertyTypeValidator = new NotNullValidator(
			"propertyType");

	private FieldValidator<String> kitchenValidator = new PositiveIntValidator(
			"kitchen");
	private FieldValidator<String> dinningRoomValidator = new PositiveIntValidator(
			"dinningRoom");
	private FieldValidator<String> roomValidator = new PositiveIntValidator(
			"room");

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
		kitchenValidator.appendError(errors, form.getKitchen());
		dinningRoomValidator.appendError(errors, form.getDinningRoom());
		roomValidator.appendError(errors, form.getRoom());
	}
}
