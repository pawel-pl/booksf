package bookshelf.core.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorMsgHolder {

	private List<ErrorObject> errors;
	
	public void addError(String code, Object[] arguments){
		
		if(errors == null){
			errors = new ArrayList<ErrorObject>();
		}
		
		errors.add(new ErrorObject(code, arguments));
	}

	public List<ErrorObject> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorObject> errors) {
		this.errors = errors;
	}
	
}
