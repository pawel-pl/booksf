package bookshelf.frontend.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.util.WebUtils;

import bookshelf.core.constants.WebConst;
import bookshelf.model.object.User;

public class LoginFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(LoginFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if (!WebConst.ENCODING.equals(request.getCharacterEncoding())) {
			request.setCharacterEncoding(WebConst.ENCODING);
		}

		User user = (User)WebUtils.getSessionAttribute((HttpServletRequest) request, WebConst.ATTRIBUTE.USER);
		String requestURI = ((HttpServletRequest)request).getRequestURI() ;

		if (user == null && (!requestURI.endsWith("login.action") && !requestURI.endsWith("loginExecute.action"))) {
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("Perform redirect to login...");
			}
			if(user == null) {
				((HttpServletResponse)response).sendRedirect("login.action");
			}else{
				request.getRequestDispatcher("/login.action").forward(
					request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
