package zonaProp.validators;


public class LengthValidator extends FieldValidator<String> {
	
	
	boolean hasName;
	public String campName;
	public int min;
	public int max;

	
	public LengthValidator(String campName, int min, int max){
		hasName=true;
		this.campName=campName;
		this.min=min;
		this.max=max;
	}
	
	public LengthValidator(int min, int max){
		hasName=false;
		this.min=min;
		this.max=max;
	}

	@Override
	public String getError() {
		return "El campo " + (hasName?campName:"") + " debe tener entre " + min + " y " + max + " caracteres.";
	}

	@Override
	public boolean isCorrect(String value) {
		return value.length()>=min && value.length()<=max;
	}
}
