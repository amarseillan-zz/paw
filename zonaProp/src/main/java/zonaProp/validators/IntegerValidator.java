package zonaProp.validators;

public class IntegerValidator extends FieldValidator<String> {
	
	public IntegerValidator(String fieldName){
		type="integerFormat";
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Ingrese un n�mero entero.";
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
