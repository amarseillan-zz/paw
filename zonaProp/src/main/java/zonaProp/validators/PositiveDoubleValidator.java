package zonaProp.validators;

public class PositiveDoubleValidator extends FieldValidator<String> {

	
	public PositiveDoubleValidator(String fieldName){
		type="positiveDoubleFormat";
		this.fieldName=fieldName;
	}
	
	@Override
	public String getError() {
		return "Error en "+ fieldName + ". Ingrese un n�mero real positivo.";
	}

	@Override
	public boolean isCorrect(String value) {
		try{
			if(Double.parseDouble(value)>=0.0)
				return true;
			return false;
		}catch(Exception e){
			return false;
		}
	}

}
