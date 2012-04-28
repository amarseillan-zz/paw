package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.IntegerValidator;
import zonaProp.web.command.SearchForm;

@Component
public class SearchFormValidator implements Validator {

	FieldValidator<String> minValidator =  new IntegerValidator("min");
	FieldValidator<String> maxValidator =  new IntegerValidator("max");
	
	public boolean supports(Class<?> clazz) {
		return SearchForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		SearchForm form = (SearchForm) target;
		
		if(!form.getMin().isEmpty())
			minValidator.appendError(errors, form.getMin());
		if(!form.getMax().isEmpty())
			maxValidator.appendError(errors, form.getMax());

	}

}
