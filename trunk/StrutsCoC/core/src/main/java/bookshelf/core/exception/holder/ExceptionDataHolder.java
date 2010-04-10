package bookshelf.core.exception.holder;

import java.io.Serializable;
import java.util.Date;

public class ExceptionDataHolder implements Serializable {

	private static final long serialVersionUID = 6676373889974527141L;
	
	private Date date;
	private String sessionId;
	private String fullStackTrace;
	private String location;
	private String message;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getFullStackTrace() {
		return fullStackTrace;
	}
	public void setFullStackTrace(String fullStackTrace) {
		this.fullStackTrace = fullStackTrace;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
