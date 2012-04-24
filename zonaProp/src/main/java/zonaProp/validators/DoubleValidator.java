package zonaProp.validators;

public class DoubleValidator extends FieldValidator<String> {

	private String fieldName;
	
	public DoubleValidator(String fieldName){
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Ingrese un nœmero real.";
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
