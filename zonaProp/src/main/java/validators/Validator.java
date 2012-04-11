package validators;

import java.security.InvalidParameterException;
import java.util.List;

public abstract class Validator<T> {

	abstract protected boolean isCorrect(T value);
	abstract protected List<String> getError();
	
	public void check(T value) throws InvalidParameterException{
		if(!isCorrect(value)){
			String errors = "";
			for(String s: getError()){
				errors += errors + " " + s;
			}
			throw new InvalidParameterException(errors);
		}
	}
	
	public List<String> validate(T value){
		if(!isCorrect(value))
			return getError();
		return null;
	}
}
