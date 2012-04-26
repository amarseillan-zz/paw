package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.LengthValidator;
import zonaProp.web.command.CommentForm;


@Component
public class CommentFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return CommentForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		CommentForm form = (CommentForm) target;
		if(!new LengthValidator("nombre de usuario", 3, 20).isCorrect(form.getName())){
			errors.rejectValue("name", "length");
		}
	}
}
