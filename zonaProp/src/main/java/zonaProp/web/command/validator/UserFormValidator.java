package zonaProp.web.command.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zonaProp.transfer.bussiness.UserType;
import zonaProp.validators.FieldValidator;
import zonaProp.validators.FileExtensionValidator;
import zonaProp.validators.FileSizeValidator;
import zonaProp.validators.LengthValidator;
import zonaProp.web.command.UserForm;


@Component
public class UserFormValidator implements Validator {

	private FieldValidator<String> usernameV = new LengthValidator("username", 4, 20);
	private FieldValidator<String> passwordV = new LengthValidator("password", 4, 20);
	private FieldValidator<String> nameV = new LengthValidator("name", 3, 20);
	private FieldValidator<String> companyNameV = new LengthValidator("companyName", 3, 20);
	private FieldValidator<String> lastNameV = new LengthValidator("lastname", 3, 20);
	private FieldValidator<String> emailV = new LengthValidator("email", 3, 20);
	private FieldValidator<String> phoneV = new LengthValidator("phone", 3,20);
	private FieldValidator<CommonsMultipartFile> fileSizeValidator = new FileSizeValidator("fileData", 2000000);
	private FieldValidator<CommonsMultipartFile> fileExtensionValidator;
	
	public boolean supports(Class<?> clazz) {
		return UserForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		UserForm form = (UserForm) target;
		if(!form.getPassword().equals(form.getPassword2())){
			errors.reject("passwordsDontMatch", "Las contrase&ntilde;as deben ser iguales.");
		}
		usernameV.appendError(errors, form.getUsername());
		passwordV.appendError(errors, form.getPassword());
		emailV.appendError(errors, form.getEmail());
		phoneV.appendError(errors, form.getPhone());	
		

		if(form.getUserType() == UserType.PRIVATEUSER){
			nameV.appendError(errors, form.getName());
			lastNameV.appendError(errors, form.getLastname());
		}
		else if(form.getUserType() == UserType.REALESTATE){
			companyNameV.appendError(errors, form.getCompanyName());
			List<String> extensions = new ArrayList<String>();
			extensions.add("jpg");
			extensions.add("JPG");
			fileExtensionValidator = new FileExtensionValidator("fileData", extensions);
			
			if(!form.getFileData().isEmpty()){
				fileSizeValidator.appendError(errors, form.getFileData());
				fileExtensionValidator.appendError(errors, form.getFileData());
			}
			else{
				errors.rejectValue("fileData", "null.user");
			}
		}
	}
}
