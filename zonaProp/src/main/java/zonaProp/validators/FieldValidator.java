package zonaProp.validators;


import org.springframework.validation.Errors;

public abstract class FieldValidator<T> {

	protected String type;
	protected String fieldName;
	
	abstract public boolean isCorrect(T value);
	abstract public String getError();
	
	public void check(T value){
		if(!isCorrect(value)){
			throw new IllegalArgumentException(getError());
		}
	}
	
	public void appendError(Errors errors, T value){
		if(!isCorrect(value)){
			errors.rejectValue(fieldName, type);
		}
	}
}
