package bookshelf.frontend.validator;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import bookshelf.model.object.SelectedBooksDTO;

public class SelectedBooksValidator implements Validator {

	private static final Logger LOG = Logger.getLogger(LoginValidator.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		
		return SelectedBooksDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		if(LOG.isDebugEnabled()){
			LOG.debug("Process free books validation "+obj);
		}
		
		if (obj == null) {
			throw new IllegalArgumentException("Dto can not be null");
		}
		
		if (errors == null) {
			throw new IllegalArgumentException("Errors can not be null");
		}
		
		SelectedBooksDTO dto = (SelectedBooksDTO)obj;
		
		if (dto.getSelectedBooks() == null || dto.getSelectedBooks().isEmpty()) {
			errors.reject("book.not.choose.error", "Choose book");
		}
	}

	
}
