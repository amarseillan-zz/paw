package validators;

import java.util.List;

public abstract class ClassValidator<T> {

	abstract protected boolean isCorrect(T value);
	abstract protected List<String> getErrors();

	
	public List<String> check(T value){
		if(!isCorrect(value))
			return getErrors();
		return null;
	}
}
