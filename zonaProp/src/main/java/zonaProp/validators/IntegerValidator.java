package zonaProp.validators;

public class IntegerValidator extends FieldValidator<String> {

	private String fieldName;
	
	public IntegerValidator(String fieldName){
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Ingrese un nœmero entero.";
	}

	@Override
	public boolean isCorrect(String value) {
		try{
			Integer.parseInt(value);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
