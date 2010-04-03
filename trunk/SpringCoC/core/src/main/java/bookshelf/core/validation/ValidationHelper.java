package bookshelf.core.validation;

public class ValidationHelper {

	public static final int LOGIN_MIN_LENGTH = 3;
	
	public static final int PASSWORD_MIN_LENGTH = 3;
	
	public static boolean hasMinLength(String obj, int minLength) {
		
		if(obj == null || obj.isEmpty()){
			return false;
		}
		
		return obj.length() >= minLength;
	}
}
