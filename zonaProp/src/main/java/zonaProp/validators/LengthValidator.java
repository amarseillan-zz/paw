package zonaProp.validators;


public class LengthValidator extends FieldValidator<String> {
	
	public String campName;
	public int min;
	public int max;

	
	public LengthValidator(String campName, int min, int max){
		this.campName=campName;
		this.min=min;
		this.max=max;
	}

	@Override
	public String getError() {
		return "El campo " + campName + " debe tener entre " + min + " y " + max + " caracteres.";
	}

	@Override
	public boolean isCorrect(String value) {
		return value.length()>=min && value.length()<=max;
	}
}
