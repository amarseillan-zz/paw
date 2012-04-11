package validators;

import java.security.InvalidParameterException;

public abstract class FieldValidator<T> {

	abstract public boolean isCorrect(T value);
	abstract public String getError();
	
	public void check(T value) throws InvalidParameterException{
		if(!isCorrect(value)){
			throw new InvalidParameterException(getError());
		}
	}
}
