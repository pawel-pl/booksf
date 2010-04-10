package bookshelf.frontend.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import bookshelf.core.exception.holder.ExceptionDataHolder;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;

public class ExceptionCheckInterceptor extends ExceptionMappingInterceptor implements StrutsStatics {

	private static final long serialVersionUID = -6034959046068465141L;
	
	private static final Integer LENGTH = 85;
	
	private static final Logger LOG = Logger.getLogger(ExceptionCheckInterceptor.class);
	
	@Override
	protected void publishException(ActionInvocation invocation, ExceptionHolder exceptionHolder) {
		
		LOG.fatal("Exception was thrown: ", exceptionHolder.getException());
		invocation.getStack().push(prepareHolder(invocation, exceptionHolder.getException()));
	}

	private ExceptionDataHolder prepareHolder(ActionInvocation actionInvocation, Exception ex){
		
		ExceptionDataHolder exh = new ExceptionDataHolder();
		
		StringBuilder sb = new StringBuilder();
	    StackTraceElement[] elem = ex.getStackTrace();
	    for (int i = 0; i < elem.length; ++i) {
	    	String line = elem[i].toString();
	    	if (line.length() > LENGTH) {
	    		sb.append(line.substring(0, LENGTH)).append("\n");
	    		sb.append(line.substring(LENGTH)).append("\n");
	    	} else {
	    		sb.append(line);
	    	}
	      sb.append("\n");
	    }
		exh.setDate(new Date());
		exh.setFullStackTrace(sb.toString());
		exh.setLocation(actionInvocation.getAction().getClass().getSimpleName());
		sb = new StringBuilder();
		if(ex.getLocalizedMessage() != null){
	    	if (ex.getLocalizedMessage().length() > LENGTH) {
	    		sb.append(ex.getLocalizedMessage().substring(0, LENGTH)).append("\n");
	    		sb.append(ex.getLocalizedMessage().substring(LENGTH)).append("\n");
	    	} else {
	    		sb.append(ex.getLocalizedMessage());
	    	}
		}

		exh.setMessage(sb.toString());
		exh.setSessionId(((HttpServletRequest) actionInvocation.getInvocationContext().get(HTTP_REQUEST)).getSession().getId());
		
		return exh;
	}

}
