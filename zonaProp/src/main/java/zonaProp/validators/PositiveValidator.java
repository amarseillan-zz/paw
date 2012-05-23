package zonaProp.validators;


public class PositiveValidator extends FieldValidator<Number> {

	public PositiveValidator(String fieldName){
		type="positive";
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". El numero tiene que ser positivo.";
	}

	@Override
	public boolean isCorrect(Number value) {
		if(value.doubleValue()>=0.0){
			return true;
		}
		return false;
	}

}
