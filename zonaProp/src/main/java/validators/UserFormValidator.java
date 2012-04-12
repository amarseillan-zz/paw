package validators;



import java.util.List;

import services.UserService;
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
		
		if(UserService.getInstance().userAlreadyExist(value.getUsername())){
			errors.add("El nombre de usuario ya existe.");	
			hasError = true;
		}
		
		hasError = campValidator("nombre de usuario", 3, 20, value.getUsername()) || hasError;
		hasError = campValidator("contrase&ntilde;a", 3, 20, value.getPassword1()) || hasError;
		hasError = campValidator("nombre", 3, 20, value.getName()) || hasError;
		hasError = campValidator("apellido", 3, 20, value.getLastname()) || hasError;
		hasError = campValidator("mail", 3, 40, value.getMail()) || hasError;
		hasError = campValidator("tel&eacute;fono", 3, 15, value.getPhone()) || hasError;
		
		return !hasError;
	}



	@Override
	protected List<String> getErrors() {
		return errors;
	}
}