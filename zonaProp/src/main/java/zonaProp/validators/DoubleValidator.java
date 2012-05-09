package zonaProp.validators;

public class DoubleValidator extends FieldValidator<String> {

	
	public DoubleValidator(String fieldName){
		type="doubleFormat";
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Ingrese un n�mero real.";
	}

	@Override
	public boolean isCorrect(String value) {
		try{
			Double.parseDouble(value);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
