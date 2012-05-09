package zonaProp.validators;

public class NotNullValidator extends FieldValidator<Object> {

	public NotNullValidator(String fieldName){
		type="null";
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Llene el campo.";
	}

	@Override
	public boolean isCorrect(Object value) {
		return value != null;
	}

}
