package validators;



import java.util.ArrayList;
import java.util.List;

import transfer.forms.UserForm;

public class UserFormValidator extends Validator<UserForm> {

	List<String> errors = new ArrayList<String>();

	public UserFormValidator() {

	}

	@Override
	protected List<String> getError() {
		return errors;
	}

	private boolean campValidator(String campName, int min, int max, String value){
		
		List<String> error = null;
		
		error = new LengthValidator(campName, min, max).validate(value);
		
		if(error != null){
			errors.add(error.get(0));
			return true;
		}
		return false;
	}
	
	@Override
	protected boolean isCorrect(UserForm value) {
		
		boolean hasError = false;
		
		if(!value.getPassword1().equals(value.getPassword2())){
			errors.add("Las contraseñas deben coincidir.");
			hasError = true;
		}
		
		hasError = campValidator("nombre de usuario", 3, 20, value.getUsername()) || hasError;
		hasError = campValidator("contraseña", 3, 20, value.getPassword1()) || hasError;
		hasError = campValidator("nombre", 3, 20, value.getName()) || hasError;
		hasError = campValidator("apellido", 3, 20, value.getLastname()) || hasError;
		hasError = campValidator("mail", 3, 40, value.getMail()) || hasError;
		hasError = campValidator("telefono", 3, 15, value.getPhone()) || hasError;
		
		return !hasError;
	}
}