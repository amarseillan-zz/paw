package validators;

import java.util.ArrayList;
import java.util.List;

public class LengthValidator extends Validator<String> {
	
	public String campName;
	public int min;
	public int max;

	
	public LengthValidator(String campName, int min, int max){
		this.campName=campName;
		this.min=min;
		this.max=max;
	}

	@Override
	protected List<String> getError() {
		List<String> errors= new ArrayList<String>();
		errors.add("El campo " + campName + " debe tener entre " + min + " y " + max + " caracteres.");
		return errors;
	}

	@Override
	protected boolean isCorrect(String value) {
		return value.length()>min && value.length()<max;
	}
}
