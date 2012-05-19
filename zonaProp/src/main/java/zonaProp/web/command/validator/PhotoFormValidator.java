package zonaProp.web.command.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.FileExtensionValidator;
import zonaProp.validators.FileSizeValidator;
import zonaProp.web.command.PhotoForm;

@Component
public class PhotoFormValidator implements Validator {

	private FieldValidator<CommonsMultipartFile> fileSizeValidator = new FileSizeValidator(
			"fileData", 2000000);
	private FieldValidator<CommonsMultipartFile> fileExtensionValidator;

	public PhotoFormValidator() {
		List<String> extensions = new ArrayList<String>();
		extensions.add("jpg");
		extensions.add("JPG");
		fileExtensionValidator = new FileExtensionValidator("fileData",
				extensions);
	}

	public boolean supports(Class<?> clazz) {
		return PhotoForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		PhotoForm form = (PhotoForm) target;

		if (!form.getFileData().isEmpty()) {
			fileSizeValidator.appendError(errors, form.getFileData());
			fileExtensionValidator.appendError(errors, form.getFileData());
		} else {
			errors.rejectValue("fileData", "null.publication");
		}
	}

}
