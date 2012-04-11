package validators;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassValidator<T> {

	protected List<String> errors = new ArrayList<String>();
	
	abstract protected boolean isCorrect(T value);
	abstract protected List<String> getErrors();

	protected boolean campValidator(String campName, int min, int max, String value){

		LengthValidator lv = new LengthValidator(campName, min, max);
		
		if(!lv.isCorrect(value)){
			errors.add(lv.getError());
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
