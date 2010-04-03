package bookshelf.frontend.validator;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import bookshelf.model.object.User;
import bookshelf.core.validation.ValidationHelper;

public class LoginValidator implements Validator {

	private static final Logger LOG = Logger.getLogger(LoginValidator.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Process user validation "+obj);
		}
		
		if (obj == null) {
			throw new IllegalArgumentException("User can not be null");
		}
		
		if (errors == null) {
			throw new IllegalArgumentException("Errors can not be null");
		}
		
		User user = (User)obj;
		
		if (!StringUtils.hasLength(user.getLogin())) {
			errors.rejectValue("login", "field.required", new Object[]{"login"}, "Field is required");
		}
		
		if (!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "field.required", new Object[]{"password"}, "Field is required");
		}
		
		if(!ValidationHelper.hasMinLength(user.getLogin(), ValidationHelper.LOGIN_MIN_LENGTH)){
			errors.rejectValue("login", "field.min.lenght", new Object[]{"login", ValidationHelper.LOGIN_MIN_LENGTH}, "Field has invalid lenght");
		}
		
		if(!ValidationHelper.hasMinLength(user.getPassword(), ValidationHelper.PASSWORD_MIN_LENGTH)){
			errors.rejectValue("password", "field.min.lenght", new Object[]{"password", ValidationHelper.PASSWORD_MIN_LENGTH}, "Field has invalid lenght");
		}
		
		if(errors.hasErrors()){
			errors.reject("form.contains.incorrect.data", "Login or passoword is incorrect");
		}
	}

}
