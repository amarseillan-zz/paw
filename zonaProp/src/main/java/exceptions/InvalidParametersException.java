package exceptions;

import java.util.List;

public class InvalidParametersException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> errors;
	
	public InvalidParametersException(List<String> errors){
		this.errors = errors;
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
}
