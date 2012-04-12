package validators;

import services.UserService;

public class UserUnicityValidator extends FieldValidator<String> {

	@Override
	public String getError() {
		return "El nombre de usuario ya existe.";
	}

	@Override
	public boolean isCorrect(String value) {
		return !UserService.getInstance().userAlreadyExist(value);
	}

}
