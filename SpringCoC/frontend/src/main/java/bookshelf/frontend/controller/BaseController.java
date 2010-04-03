package bookshelf.frontend.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public abstract class BaseController {

	protected Validator validator;

	protected void validate(Object obj2validate, Errors errors) {
		
		if(validator != null){
			ValidationUtils.invokeValidator(validator, obj2validate, errors);
		}	
	}
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
