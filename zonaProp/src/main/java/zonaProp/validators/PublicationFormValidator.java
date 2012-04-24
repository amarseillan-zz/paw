package zonaProp.validators;

import java.util.List;

import zonaProp.transfer.forms.PublicationForm;

public class PublicationFormValidator extends ClassValidator<PublicationForm> {

	@Override
	protected List<String> getErrors() {
		return errors;
	}

	@Override
	protected boolean isCorrect(PublicationForm value) {
		
		boolean hasError = false;
		
		hasError = campValidator(new LengthValidator("direccion",1,30),value.getAddress()) || hasError;
		hasError = campValidator(new LengthValidator("ciudad",1,30),value.getCity()) || hasError;
		hasError = campValidator(new DoubleValidator("precio"),value.getPrice()) || hasError;
		hasError = campValidator(new DoubleValidator("superficie cubierta"),value.getCovered()) || hasError;
		hasError = campValidator(new DoubleValidator("superficie descubierta"),value.getUncovered()) || hasError;
		hasError = campValidator(new IntegerValidator("antiguedad"),value.getAge()) || hasError;
		
		return !hasError;
	}

}
