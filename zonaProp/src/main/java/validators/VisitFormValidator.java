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
		
		hasError = campValidator("nombre de usuario", 3, 40, value.getEmail()) || hasError;
		hasError = campValidator("contraseña", 3, 15, value.getPhone()) || hasError;
		hasError = campValidator("nombre", 3, 20, value.getName()) || hasError;
		
		return !hasError;
	}

}
