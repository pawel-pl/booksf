package bookshelf.core.validation;

public class ValidationHelper {

	public static final int LOGIN_MIN_LENGTH = 3;
	
	public static final int PASSWORD_MIN_LENGTH = 3;
	
	public static final String DATE_PATTERN ="(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])";
	
	public static boolean hasMinLength(String obj, int minLength) {
		
		if(obj == null || obj.isEmpty()){
			return false;
		}
		
		return obj.length() >= minLength;
	}
	
	public static boolean isDateValidPattern(String dateString){
		
		if(dateString == null){
			return false;
		}
		
		return dateString.matches(DATE_PATTERN);
	}
}
