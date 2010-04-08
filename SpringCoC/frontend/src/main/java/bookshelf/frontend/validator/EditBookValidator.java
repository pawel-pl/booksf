package bookshelf.frontend.validator;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import bookshelf.core.validation.ValidationHelper;
import bookshelf.model.object.Book;

public class EditBookValidator implements Validator {

	private static final Logger LOG = Logger.getLogger(LoginValidator.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		
		return Book.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Process book validation "+obj);
		}
		
		if (obj == null) {
			throw new IllegalArgumentException("Book can not be null");
		}
		
		if (errors == null) {
			throw new IllegalArgumentException("Errors can not be null");
		}
		
		Book book = (Book)obj;
		
		if (!StringUtils.hasLength(book.getAuthorName())) {
			errors.rejectValue("authorName", "field.required", new Object[]{"authorName"}, "Field is required");
		}
		
		if (!StringUtils.hasLength(book.getAuthorLastName())) {
			errors.rejectValue("authorLastName", "field.required", new Object[]{"authorLastName"}, "Field is required");
		}
		
		if(!ValidationHelper.hasMinLength(book.getAuthorName(), ValidationHelper.LOGIN_MIN_LENGTH)){
			errors.rejectValue("authorName", "field.min.lenght", new Object[]{"authorName", ValidationHelper.LOGIN_MIN_LENGTH}, "Field has invalid lenght");
		}
		
		if(!ValidationHelper.hasMinLength(book.getAuthorLastName(), ValidationHelper.PASSWORD_MIN_LENGTH)){
			errors.rejectValue("authorLastName", "field.min.lenght", new Object[]{"authorLastName", ValidationHelper.PASSWORD_MIN_LENGTH}, "Field has invalid lenght");
		}
		
		if (!StringUtils.hasLength(book.getTitel())) {
			errors.rejectValue("titel", "field.required", new Object[]{"titel"}, "Field is required");
		}
		
		if(!ValidationHelper.hasMinLength(book.getTitel(), ValidationHelper.LOGIN_MIN_LENGTH)){
			errors.rejectValue("titel", "field.min.lenght", new Object[]{"titel", ValidationHelper.LOGIN_MIN_LENGTH}, "Field has invalid lenght");
		}
		
		if(errors.hasErrors()){
			errors.reject("form.contains.incorrect.data");
		}
	}
}
