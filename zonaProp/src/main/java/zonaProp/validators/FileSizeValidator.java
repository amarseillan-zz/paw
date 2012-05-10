package zonaProp.validators;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class FileSizeValidator extends FieldValidator<CommonsMultipartFile> {

	public int max;

	
	public FileSizeValidator(String fieldName, int max){
		this.type="size";
		this.fieldName=fieldName;
		this.max=max;
	}

	@Override
	public String getError() {
		return "El tamaño del archivo debe ser menor a "+max+".";
	}

	@Override
	public boolean isCorrect(CommonsMultipartFile value) {
		return value.getSize()<=max && value.getSize()>=0;
	}
}
