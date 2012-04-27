package zonaProp.validators;

import java.security.InvalidParameterException;

import org.springframework.validation.Errors;

public abstract class FieldValidator<T> {

	protected String type;
	protected String fieldName;
	
	abstract public boolean isCorrect(T value);
	abstract public String getError();
	
	public void check(T value) throws InvalidParameterException{
		if(!isCorrect(value)){
			throw new InvalidParameterException(getError());
		}
	}
	
	public void appendError(Errors errors, T value){
		if(!isCorrect(value)){
			errors.rejectValue(fieldName, type);
		}
	}
}
