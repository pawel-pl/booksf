package bookshelf.frontend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import bookshelf.core.constants.WebConst;
import bookshelf.model.object.RoleType;
import bookshelf.model.object.User;

public class AccessInterceptor extends HandlerInterceptorAdapter {

	public static final Logger LOG = Logger.getLogger(AccessInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		User user = (User)WebUtils.getSessionAttribute((HttpServletRequest) request, WebConst.ATTRIBUTE.USER);
		
		if(user.getRole().getRole() != RoleType.ADMIN){
			
			LOG.debug("User do not have right to this operation");
			request.getRequestDispatcher("/accessDenied.do").forward(
					request, response);
			
			return false;
		}
		
		return true;
	}
}
