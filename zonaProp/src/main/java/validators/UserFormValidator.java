package validators;



import java.util.List;

import transfer.forms.UserForm;

public class UserFormValidator extends ClassValidator<UserForm> {


	public UserFormValidator() {

	}
	
	@Override
	protected boolean isCorrect(UserForm value) {
		
		boolean hasError = false;
		
		if(!value.getPassword1().equals(value.getPassword2())){
			errors.add("Las contrase&ntilde;as deben coincidir.");
			hasError = true;
		}
		
		hasError = campValidator(new UserUnicityValidator(),value.getUsername()) || hasError;
		hasError = campValidator(new LengthValidator("nombre de usuario", 3, 20), value.getUsername()) || hasError;
		hasError = campValidator(new LengthValidator("contrase&ntilde;a", 3, 20), value.getPassword1()) || hasError;
		hasError = campValidator(new LengthValidator("nombre", 3, 20), value.getName()) || hasError;
		hasError = campValidator(new LengthValidator("apellido", 3, 20), value.getLastname()) || hasError;
		hasError = campValidator(new LengthValidator("mail", 3, 40), value.getMail()) || hasError;
		hasError = campValidator(new LengthValidator("tel&eacute;fono", 3, 15), value.getPhone()) || hasError;
		
		return !hasError;
	}



	@Override
	protected List<String> getErrors() {
		return errors;
	}
}