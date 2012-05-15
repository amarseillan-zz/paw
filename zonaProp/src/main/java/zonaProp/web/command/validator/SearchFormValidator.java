package zonaProp.web.command.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import zonaProp.validators.FieldValidator;
import zonaProp.validators.PositiveIntValidator;
import zonaProp.web.command.SearchForm;

@Component
public class SearchFormValidator implements Validator {

	FieldValidator<String> minValidator =  new PositiveIntValidator("min");
	FieldValidator<String> maxValidator =  new PositiveIntValidator("max");
	
	public boolean supports(Class<?> clazz) {
		return SearchForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		SearchForm form = (SearchForm) target;
		
		if(form.getMin()!=null && !form.getMin().isEmpty())
			minValidator.appendError(errors, form.getMin());
		if(form.getMax()!=null && !form.getMax().isEmpty())
			maxValidator.appendError(errors, form.getMax());

	}

}
