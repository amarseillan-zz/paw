package validators;

import java.util.List;

import transfer.forms.VisitForm;

public class VisitFormValidator extends ClassValidator<VisitForm> {
	
	@Override
	protected List<String> getErrors() {
		return errors;
	}

	@Override
	protected boolean isCorrect(VisitForm value) {
		
		boolean hasError = false;
		
		hasError = campValidator(new LengthValidator("nombre de usuario", 3, 20), value.getEmail()) || hasError;
		hasError = campValidator(new LengthValidator("contrase&ntilde;a", 3, 20), value.getPhone()) || hasError;
		hasError = campValidator(new LengthValidator("nombre", 3, 20), value.getName()) || hasError;
		
		return !hasError;
	}

}
