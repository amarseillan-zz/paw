package zonaProp.validators;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class FileExtensionValidator extends FieldValidator<CommonsMultipartFile> {

	public List<String> extensions;

	
	public FileExtensionValidator(String fieldName, List<String> extensions){
		this.type="ext";
		this.fieldName=fieldName;
		this.extensions=extensions;
	}

	@Override
	public String getError() {
		return "El formato del archivo es incorrecto.";
	}

	@Override
	public boolean isCorrect(CommonsMultipartFile value) {
		String[] aux = value.getOriginalFilename().split("\\.");
		if(aux.length > 1){
			String extension =  aux[aux.length-1];
			if(extensions.contains(extension)){
				return true;
			}
		}
		return false;
	}
}
