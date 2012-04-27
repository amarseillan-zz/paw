package zonaProp.validators;


public class LengthValidator extends FieldValidator<String> {
	
	
	public int min;
	public int max;

	
	public LengthValidator(String fieldName, int min, int max){
		this.type="length";
		this.fieldName=fieldName;
		this.min=min;
		this.max=max;
	}

	@Override
	public String getError() {
		return "El campo " + fieldName + " debe tener entre " + min + " y " + max + " caracteres.";
	}

	@Override
	public boolean isCorrect(String value) {
		return value.length()>=min && value.length()<=max;
	}
}
