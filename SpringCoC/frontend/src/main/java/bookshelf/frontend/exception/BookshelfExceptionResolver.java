package bookshelf.frontend.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.util.WebUtils;

import bookshelf.core.constants.WebConst;
import bookshelf.core.exception.holder.ExceptionDataHolder;

public class BookshelfExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Integer LENGTH = 85;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		System.out.println(handler);
		
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
		exh.setLocation(request.getRequestURI());
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
		exh.setSessionId(WebUtils.getSessionId(request));
		
		request.setAttribute(WebConst.ATTRIBUTE.EXCEPTION_DATA_HOLDER, exh);
		
		return super.resolveException(request, response, handler, ex);
	}
}
