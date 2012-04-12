package validators;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassValidator<T> {

	protected List<String> errors = new ArrayList<String>();
	
	abstract protected boolean isCorrect(T value);
	abstract protected List<String> getErrors();

	protected <S> boolean campValidator(FieldValidator<S> fv, S value){
		
		if(!fv.isCorrect(value)){
			errors.add(fv.getError());
			return true;
		}
		return false;
	}
	
	
	
	public List<String> check(T value){
		if(!isCorrect(value))
			return getErrors();
		return null;
	}
}
