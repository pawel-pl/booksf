package bookshelf.frontend.interceptor;

import org.apache.log4j.Logger;

import bookshelf.core.constants.WebConst;
import bookshelf.model.object.RoleType;
import bookshelf.model.object.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AccessInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1254037336878027966L;

	private static final Logger LOG = Logger.getLogger(AccessInterceptor.class);

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		User user = (User)actionInvocation.getInvocationContext().
			getSession().get(WebConst.ATTRIBUTE.USER);
		
		if(user.getRole().getRole() != RoleType.ADMIN){
			
			LOG.warn("User do not have right to this operation");
			
			return WebConst.RESULT.ACCESS_DENIED;
		}
		
		return actionInvocation.invoke();
	}

}
