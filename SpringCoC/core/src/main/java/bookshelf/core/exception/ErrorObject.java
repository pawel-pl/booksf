package bookshelf.core.exception;

public class ErrorObject {

	private String code;
	
	private Object[] arguments;
	
	public ErrorObject(){
		
	}
	
	public ErrorObject(String code, Object[] arguments){
		this.code = code;
		this.arguments = arguments;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}
	
}
