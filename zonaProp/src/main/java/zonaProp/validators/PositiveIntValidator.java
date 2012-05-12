package zonaProp.validators;

public class PositiveIntValidator extends FieldValidator<String>  {

		public PositiveIntValidator(String fieldName){
			type="positiveIntegerFormat";
			this.fieldName=fieldName;
		}
		
		@Override
		public String getError() {
			return "Error en "+ fieldName + ". Ingrese un n�mero entero positivo.";
		}

		@Override
		public boolean isCorrect(String value) {
			try{
				if(Integer.parseInt(value)>=0)
					return true;
				return false;
			}catch(Exception e){
				return false;
			}

	}
}
